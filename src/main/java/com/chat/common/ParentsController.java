package com.chat.common;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chat.entity.UserInfo;
import com.chat.result.ResultVo;
import com.chat.result.View;
import com.chat.util.Constant;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 抽象父类--简单的增删查改
 * 泛型参数思想 需要什么就用什么
 */
@Api(value = "后台接口")
public class ParentsController<BaseServiceImpl extends ParentsService,T,PK extends Serializable> {

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private HttpServletRequest request;
    /**
     * 服务层
     */
    @Autowired
    private BaseServiceImpl baseServiceImpl;


    /**添加
     *
     * @param t
     * @return
     */
    @ApiOperation(value = "添加",position = 1)
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "")})
    @Transactional// 开启事务
    @PostMapping("/add")
    public T add(@RequestBody T t){
        //设置通用字段
        setValue(t,"creatTime",new Date());
        boolean insert = baseServiceImpl.insert(t);
        return t;
    }

    /**
     * 修改
     * @param t
     * @return
     */
    @ApiOperation(value = "修改")
    @Transactional
    @PostMapping("/update")
    public String update(@RequestBody T t){
        //设置通用字段
        setValue(t,"updateTime",new Date());
        boolean update = baseServiceImpl.updateById(t);

        String result = "";
        if (update){
            result = "success";
        }else {
            result  = "lose";
        }
        return result;
    }
    public String deleteById(long id){
        boolean delete = baseServiceImpl.deleteById(id);
        if (delete){
            return "";
        }else {
            return "";
        }
    }
    /**
     * 逻辑删除
     * @return
     */
    @ApiOperation(value = "批量删除")
    @DeleteMapping("delete")
    @Transactional
    public String deleteAllById(@RequestBody List<PK> ids){
        List<T> tList = new ArrayList<T>();
        ids.forEach(id ->{
            T t = (T)baseServiceImpl.selectById(id);
            setValue(t,"isDelete",1);
            tList.add(t);
        });
        boolean update = baseServiceImpl.updateBatchById(tList);
        String result = "";
        if (update){
            result = "success";
        }else {
            result = "lose";
        }
        return result;
    }

    /**
     * 使用@JsonView(View.User.class) 后 封装不能太多
     *
     *
     * 查询所有
     * @param current
     * @param size
     * @return
     */
    @ApiOperation(value = "查询所有--有分页")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "int")
    })
    @JsonView(View.User.class)
    @GetMapping("/all")
    public ResultVo selectByAll(int current, @RequestParam(required = false) Integer size){
        //分页类
        Page<T> page = new Page<T>(current,size == null ? Constant.PAGE_SIZE : size);
       Page<T> date =  baseServiceImpl.selectPage(page,getWrapper());

        return ResultVo.success(Constant.HTTP_400,"success",date.getRecords())
                .setTotal( date.getTotal())
                .setCurrents(date.getCurrent());
    }
    //获得过滤条件 复杂查询可重写此方法
    public EntityWrapper getWrapper(){
        EntityWrapper<T> wrapper = new EntityWrapper<T>();
        setWrapper(wrapper);

        return wrapper;
    }
    @GetMapping("/get")
    public String selectByReq(){
        //获得所有参数与值
        Map<String,String[]> map = request.getParameterMap();
        map.get("").toString();
        System.out.println(map);
        return "success";
    }


    //设置  删除过滤条件
    public void setWrapper(EntityWrapper wrapper){
        //查询没有被删除的
        wrapper.eq("is_delete",0);
    }
    /**
     * 设置字段值
     * @param entity
     * @param fieldName
     * @param value
     * @return
     */
    public T setValue(T entity,String fieldName,Object value){
        if (StringUtils.isBlank(fieldName)|| value == null) return entity;
        Class<T> tClass = (Class<T>) entity.getClass();
        try {
            Field field = tClass.getDeclaredField(fieldName);
            if (field != null){
                //开启对私有字段进行设置值
                field.setAccessible(true);
                field.set(entity,value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }
}

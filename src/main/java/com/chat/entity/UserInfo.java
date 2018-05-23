package com.chat.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.chat.result.View;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author taotao
 * @since 2018-05-17
 */
@TableName("user_info")
public class UserInfo extends Model<UserInfo> {

    private static final long serialVersionUID = 1L;
    @JsonView(View.User.class)
    @TableId(value = "uid", type = IdType.AUTO)
    private Long uid;

    @JsonView(View.User.class)
    private String name;

    @JsonView(View.Admin.class)
    private String password;

    @JsonView(View.User.class)
    private String ipone;

    @JsonView(View.User.class)
    private String email;

    @JsonView(View.User.class)
    @TableField("creat_time")
    private Date creatTime;

    @JsonView(View.User.class)
    @TableField("update_time")
    private Date updateTime;

    @JsonView(View.Admin.class)
    @TableField("is_delete")
    private Integer isDelete;

    @JsonView(View.Admin.class)
    private Integer type;

    @JsonView(View.Admin.class)
    @TableField("prent_uid")
    private Long prentUid;


    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIpone() {
        return ipone;
    }

    public void setIpone(String ipone) {
        this.ipone = ipone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getPrentUid() {
        return prentUid;
    }

    public void setPrentUid(Long prentUid) {
        this.prentUid = prentUid;
    }

    @Override
    protected Serializable pkVal() {
        return this.uid;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
        ", uid=" + uid +
        ", name=" + name +
        ", password=" + password +
        ", ipone=" + ipone +
        ", email=" + email +
        ", creatTime=" + creatTime +
        ", updateTime=" + updateTime +
        ", isDelete=" + isDelete +
        ", type=" + type +
        ", prentUid=" + prentUid +
        "}";
    }
}

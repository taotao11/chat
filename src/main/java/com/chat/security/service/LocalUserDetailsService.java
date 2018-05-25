package com.chat.security.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chat.entity.SysRole;
import com.chat.entity.UserInfo;
import com.chat.service.SysRoleService;
import com.chat.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户验证判断
 * 实现UserDetailsService 接口
 *
 *  boolean enabled = true; // 可用性 :true:可用 false:不可用
 *  boolean accountNonExpired = true; // 过期性 :true:没过期 false:过期boolean
 *  credentialsNonExpired = true; // 有效性 :true:凭证有效 false:凭证无效
 *  boolean accountNonLocked = true; // 锁定性 :true:未锁定 false:已锁定
 */
public class LocalUserDetailsService implements UserDetailsService {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private SysRoleService sysRoleService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo info = userInfoService.selectOne(new EntityWrapper<UserInfo>()
        .eq("name",s));
        //用户验证
        if (info == null){
            System.out.println("用户不存在!!!");
            throw new UsernameNotFoundException("用户不存在!!!!");
        }
        //拿到角色
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        List<SysRole> roles = sysRoleService.selectByUid(info.getUid());
        if (roles == null ||roles.size() == 0){
            System.out.println("用户不存在!!!");
            throw new UsernameNotFoundException("用户没有角色!!!!");
        }
        roles.forEach(role->{
            System.out.println("ROLE_" + role.getRole());
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
        });

        return new User(info.getName(),info.getPassword(),list);
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //加密
        String pwd = encoder.encode("123456");
        System.out.println(pwd);
    }
}

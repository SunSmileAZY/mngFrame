package com.anzy.frame.security;

import com.anzy.bussiness.sys.dao.RoleDao;
import com.anzy.bussiness.sys.dao.RolePermissionDao;
import com.anzy.bussiness.sys.entity.Role;
import com.anzy.bussiness.sys.entity.User;
import com.anzy.bussiness.sys.service.RoleService;
import com.anzy.bussiness.sys.service.UserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.Sha256CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by anzy on 2018/3/8.
 */
@Component
public class ShiroSecurityRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RolePermissionDao rolePermissionDao;

    public ShiroSecurityRealm() {
        setName("ShiroSecurityRealm"); // This name must match the name in the SysUser class's getPrincipals() method
        setCredentialsMatcher(new Sha256CredentialsMatcher());
    }

    /**
     * 权限认证
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Long userId = (Long) principals.fromRealm(getName()).iterator().next();
        User user = userService.selectById(userId);
        if (user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            List<Role> roles = roleDao.listByUserId(userId);
            for (Role role : roles) {
                info.addRole(role.getRoleKey());
                List<String> permissions = rolePermissionDao.listByRoleId(role.getRoleId());
                info.addStringPermissions(permissions);
            }
            return info;
        } else {
            return null;
        }
    }


    /**
     * 登录认证
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User user = userService.selectOne(new EntityWrapper<User>().eq("login_Account", token.getUsername()));
        if (user != null) {
            return new SimpleAuthenticationInfo(user.getUserId(), user.getLoginPass(), getName());
        } else {
            return null;
        }
    }

}

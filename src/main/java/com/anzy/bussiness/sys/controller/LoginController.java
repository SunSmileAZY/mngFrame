package com.anzy.bussiness.sys.controller;

import com.anzy.bussiness.sys.entity.User;
import com.anzy.bussiness.sys.service.UserService;
import com.anzy.frame.comm.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by anzy on 2017/12/4.
 */
@Controller
@RequestMapping("/login/")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("init")
    public String login(String username,String pwd,String vCode){
        return "sys/login";
    }

    @ResponseBody
    @RequestMapping(value = "doLogin")
    public String doLogin(HttpServletRequest request) {
        String msg = "success";
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        System.out.println(userName);
        System.out.println(password);
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            if (subject.isAuthenticated()) {
                List<User> users = userService.findByUsernameAndPwd(userName,password);
                request.getSession().setAttribute(Constants.SESN_USR_ACOUNT,userName);
                request.getSession().setAttribute(Constants.SESN_USR,users.get(0));
            } else {
            }
        } catch (IncorrectCredentialsException e) {
            msg = "登录密码错误";
            System.out.println(msg);
        } catch (ExcessiveAttemptsException e) {
            msg = "登录失败次数过多";
            System.out.println(msg);
        } catch (LockedAccountException e) {
            msg = "帐号已被锁定";
            System.out.println(msg);
        } catch (DisabledAccountException e) {
            msg = "帐号已被禁用";
            System.out.println(msg);
        } catch (ExpiredCredentialsException e) {
            msg = "帐号已过期";
            System.out.println(msg);
        } catch (UnknownAccountException e) {
            msg = "帐号不存在";
            System.out.println(msg);
        } catch (UnauthorizedException e) {
            msg = "您没有得到相应的授权！";
            System.out.println(msg);
        }
        return msg;
    }

}

package com.anzy.bussiness.sys.controller;

import com.anzy.bussiness.sys.entity.User;
import com.anzy.bussiness.sys.service.UserService;
import com.anzy.frame.base.controller.AbstractController;
import com.anzy.frame.comm.Constants;
import com.anzy.frame.utils.R;
import com.anzy.frame.utils.RedisUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by anzy on 2017/12/4.
 */
@Controller
@RequestMapping("/login/")
public class LoginController extends AbstractController {

    @Autowired
    private UserService userService;

    @RequestMapping("init")
    public String login(String username, String pwd, String vCode) {
        return "sys/login";
    }

    @Autowired
    private RedisUtil redisUtil;

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
//                List<User> users = userService.findByUsernameAndPwd(userName, password);
                List<User> users = null;
                request.getSession().setAttribute(Constants.SESN_USR_ACOUNT, userName);
                request.getSession().setAttribute(Constants.SESN_USR, users.get(0));
                String sessionId = request.getSession().getId();
                redisUtil.hset(sessionId, Constants.SESN_USR, users.get(0), Constants.TIME_OUT);
                redisUtil.hset(sessionId, Constants.SESN_USR_ACOUNT, userName, Constants.TIME_OUT);
                logger.info("request.getSession().getId():" + sessionId);
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
    @ResponseBody
    @RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
    public String login(User user,boolean rememberMe) throws IOException {
        String msg = "success";
        User userInfo = userService.selectOne(new EntityWrapper<User>().eq("login_Account", user.getLoginAccount()));
        if(userInfo==null){
            return  "用户名错误";
        }
        if(!userInfo.getLoginPass().equals(new Sha256Hash(user.getLoginPass()).toHex())){
            return "密码错误";
        }
        //存入session
        Subject subject = SecurityUtils.getSubject();
        //记得传入明文密码
        subject.login(new UsernamePasswordToken(userInfo.getLoginAccount(), user.getLoginPass(), rememberMe));
        session.setAttribute(Constants.SESN_USR, userInfo);
        return msg;
    }
}

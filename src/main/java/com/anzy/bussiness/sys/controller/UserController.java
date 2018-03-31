package com.anzy.bussiness.sys.controller;

import com.anzy.bussiness.sys.entity.qo.UserQO;
import com.anzy.bussiness.sys.service.UserService;
import com.anzy.frame.base.controller.AbstractController;
import com.anzy.frame.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by anzy on 2017/12/1.
 */
@Controller
@RequestMapping("/user")
public class UserController extends AbstractController {

    @Resource
    private UserService userService;

    @RequestMapping(value = {"/init", ""})
    public String index(HttpServletRequest request) {
        logger.info("进入用户管理界面request.getSession().getId():" + request.getSession().getId());
        return "sys/user";
    }

    @ResponseBody
    @RequestMapping(value = "listUser", method = RequestMethod.GET)
    public R listUser(UserQO userQO) {
        logger.info("分页查询用户信息！userQO：" + userQO);
        return userService.listUserPage(userQO);
    }


}
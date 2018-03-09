package com.anzy.bussiness.sys.controller;

import com.anzy.bussiness.sys.service.UserService;
import com.anzy.frame.base.controller.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by anzy on 2017/12/1.
 */
@Controller
@RequestMapping("/user")
public class UserController extends AbstractController {

    @Resource
    private UserService userService;

    @RequestMapping("/init")
    public String index(HttpServletRequest request) {
        logger.info("request.getSession().getId():" + request.getSession().getId());
        return "sys/user";
    }

}
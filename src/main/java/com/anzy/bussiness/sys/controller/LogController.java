package com.anzy.bussiness.sys.controller;

import com.anzy.frame.base.controller.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志控制层
 * Created by anzy on 2018/4/13.
 */
@Controller
@RequestMapping("/log/")
public class LogController extends AbstractController {


    @RequestMapping(value = {"/init", ""})
    public String index(HttpServletRequest request) {
        logger.info("进入日志管理界面request.getSession().getId():" + request.getSession().getId());
        return "sys/log";
    }

}

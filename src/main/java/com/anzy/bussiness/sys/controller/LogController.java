package com.anzy.bussiness.sys.controller;

import com.anzy.bussiness.sys.entity.qo.LogQO;
import com.anzy.bussiness.sys.entity.qo.UserQO;
import com.anzy.bussiness.sys.service.LogService;
import com.anzy.frame.base.controller.AbstractController;
import com.anzy.frame.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志控制层
 * Created by anzy on 2018/4/13.
 */
@Controller
@RequestMapping("/log/")
public class LogController extends AbstractController {

    @Autowired
    private LogService logService;

    @RequestMapping(value = {"/init", ""})
    public String index(HttpServletRequest request) {
        return "sys/log";
    }

    @ResponseBody
    @RequestMapping(value = "listLog", method = RequestMethod.GET)
    public R listLog(LogQO logQO) {
        logger.info("分页查询日志信息！logQO：" + logQO);
        return logService.listLogPage(logQO);
    }



}

package com.anzy.frame.interceptor;

/**
 * Created by anzy on 2017/12/2.
 */

import com.anzy.frame.utils.JsonUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;

import java.util.ArrayList;

//@Aspect
public class LogInterceptor implements Ordered {

    private int order;
    public void setOrder(int order) {
        this.order = order;
    }
    public int getOrder() {
        return order;
    }
    private final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

//    @Before("execution (* com.anzy.bussiness.sys.*.*.*.*(..))")
    public void doBefore(JoinPoint jp){
//        System.out.print("进入dobefore===============");
        if(logger.isInfoEnabled()){
            String strLog =  jp.getTarget().getClass().getName() + "." + jp.getSignature().getName();
            ArrayList<Object> aList = new ArrayList<Object>();

            for(Object obj : jp.getArgs()){
                if(obj != null && (obj.getClass().getName().startsWith("java.lang") || obj.getClass().getName().startsWith("com.anzy"))){
                    aList.add(obj);
                }
            }

            logger.info(strLog + "] [开始] [参数："+ JsonUtil.writeValueAsString(aList));
        }
    }

//    @AfterReturning(value = "execution (* com.anzy.bussiness.sys.service.impl.*.*(..))",  returning="rtv")
    private void doAfterReturning(JoinPoint jp, Object rtv){
        if(logger.isInfoEnabled()){
            String strLog =  jp.getTarget().getClass().getName() + "." + jp.getSignature().getName();
            logger.info(strLog+ "] [结束]"+"[Return:" + rtv + "]");
        }
    }
}
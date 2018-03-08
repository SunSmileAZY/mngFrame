package com.anzy.frame.security;

import org.apache.shiro.web.filter.PathMatchingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by anzy on 2018/3/8.
 */
public class SysUserFilter  extends PathMatchingFilter {

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        //可以参考http://jinnianshilongnian.iteye.com/blog/2025656
        return true;
    }
}

package com.anzy.frame.filter;


import com.anzy.frame.comm.Constants;
import org.apache.log4j.MDC;
import org.elasticsearch.common.netty.handler.codec.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by anzy on 2018/4/9.
 */
@Component
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        MDC.put("user", req.getSession().getAttribute(Constants.SESN_USR_NAME));
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

package com.anzy.frame.interceptor;

import com.anzy.bussiness.sys.entity.User;
import com.anzy.frame.comm.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 拦截器，超时重新登录
 * Created by anzy on 2017/12/4.
 */
public class SessionInterceptor implements HandlerInterceptor {
    private static final Logger LOG = Logger.getLogger(SessionInterceptor.class);

    /** 不需要拦截的url正则表达式，与antiInterceptURL有区别，后者必须是用户登陆后 */
    @Value("#{propertyConfig['excludeUrls']}")
    private String excludeUrls;

    @Override
    public void afterCompletion(HttpServletRequest arg0,HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        String requestUrl = request.getRequestURI().replace( request.getContextPath(), "");
        response.setContentType("text/html; charset=utf-8");

        // config.properties文件中配置的不需要拦截的url
        if (StringUtils.isNotBlank(excludeUrls)) {
            if (excludeUrls.contains(requestUrl)) {
                LOG.info("访问config文件中配置的免拦截URL,url:" + requestUrl);
                return true;
            }
        }
        User user = (User) request.getSession().getAttribute(Constants.SESN_USR);
        System.out.println("请求来了===user：" + user+",url:"+requestUrl);
        if (user != null) {
            // 返回true，则这个方面调用后会接着调用postHandle(), afterCompletion()
            return true;
        } else {
            // 未登录 跳转到登录页面
            PrintWriter out = response.getWriter();
            StringBuffer builder = new StringBuffer();
            builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
			builder.append("alert(\"页面过期，请重新登录\");");
            System.out.println(request.getContextPath());
            builder.append("window.top.location.href=\""+ request.getContextPath() + "/login/login\"");
            builder.append("</script>");
            out.print(builder.toString());
            out.close();
        }
        return false;
    }
}

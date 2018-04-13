package com.anzy.frame.interceptor;

import com.anzy.frame.comm.Constants;
import com.anzy.frame.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
/**
 * 拦截器，日志拦截器  20180309
 * Created by anzy on 2017/12/4.
 */
public class SessionInterceptor implements HandlerInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(SessionInterceptor.class);
    private static final ThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("ThreadLocal StartTime");

//    @Autowired
//    private RedisUtil redisUtil;

    /**
     * 不需要拦截的url正则表达式，与antiInterceptURL有区别，后者必须是用户登陆后
     */
//    @Value("#{propertyConfig['excludeUrls']}")
//    private String excludeUrls;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        String user = request.getSession().getAttribute(Constants.SESN_USR_NAME)+"";
        MDC.put("user", StringUtils.isBlank(user)?"":user );
        MDC.put("system_type","mngFrame");
        if (LOG.isDebugEnabled()){
            long beginTime = System.currentTimeMillis();//1、开始时间
            startTimeThreadLocal.set(beginTime);		//线程绑定变量（该数据只有当前请求的线程可见）
            LOG.debug("开始计时: {}  URI: {}", new SimpleDateFormat("hh:mm:ss.SSS").format(beginTime), request.getRequestURI());
        }
        return true;
//        String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");
//        response.setContentType("text/html; charset=utf-8");
//
//        // config.properties文件中配置的不需要拦截的url
//        if (StringUtils.isNotBlank(excludeUrls)) {
//            if (excludeUrls.contains(requestUrl)) {
//                LOG.info("访问config文件中配置的免拦截URL,url:" + requestUrl);
//                return true;
//            }
//        }
//        //获得sessionID
//        String sessionId = request.getSession().getId();
//        User usr = (User) redisUtil.hget(sessionId, Constants.SESN_USR);
//        System.out.println("请求来了===user：" + usr + ",url:" + requestUrl);
//        if (usr != null) {
//            //刷新过期时间
//            redisUtil.expire(sessionId, Constants.TIME_OUT);
//            // 返回true，则这个方面调用后会接着调用postHandle(), afterCompletion()
//            return true;
//        } else {
//            // 未登录 跳转到登录页面
//            PrintWriter out = response.getWriter();
//            StringBuffer builder = new StringBuffer();
//            builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
//            builder.append("alert(\"页面过期，请重新登录\");");
//            System.out.println(request.getContextPath());
//            builder.append("window.top.location.href=\"" + request.getContextPath() + "/login/init\"");
//            builder.append("</script>");
//            out.print(builder.toString());
//            out.close();
//        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        if (modelAndView != null){
            LOG.info("ViewName: " + modelAndView.getViewName());
        }
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 打印JVM信息。
        if (LOG.isDebugEnabled()) {
            long beginTime = startTimeThreadLocal.get();//得到线程绑定的局部变量（开始时间）
            long endTime = System.currentTimeMillis();    //2、结束时间
            LOG.debug("计时结束：{}  耗时：{}  URI: {}  最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
                    new SimpleDateFormat("hh:mm:ss.SSS").format(endTime), DateUtils.formatDateTime(endTime - beginTime),
                    request.getRequestURI(), Runtime.getRuntime().maxMemory()/1024/1024, Runtime.getRuntime().totalMemory()/1024/1024, Runtime.getRuntime().freeMemory()/1024/1024,
                    (Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory())/1024/1024);
            //删除线程变量中的数据，防止内存泄漏
            startTimeThreadLocal.remove();
        }
    }
}

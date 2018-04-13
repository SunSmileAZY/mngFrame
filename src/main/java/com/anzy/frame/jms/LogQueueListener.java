package com.anzy.frame.jms;

import com.anzy.bussiness.sys.entity.Log;
import com.anzy.bussiness.sys.service.LogService;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.elasticsearch.common.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.util.Date;

/**
 * Created by anzy on 2018/4/12.
 */
@Component
public class LogQueueListener implements MessageListener {
    public static Logger logger = Logger.getLogger(LogQueueListener.class);
    @Autowired
    private LogService logService;

    public void onMessage(final Message message) {
        if (message instanceof ObjectMessage) {
            //获取mq上日志入库
            try {
                final LoggingEvent loggingEvent = (LoggingEvent) ((ObjectMessage) message).getObject();
                LoggingEventWrapper loggingEventWrapper = new LoggingEventWrapper(loggingEvent);
                Log log = new Log();
                log.setDetail(loggingEventWrapper.getDetail());
                log.setHostName(loggingEventWrapper.getHostName());
                log.setIpAddress(loggingEventWrapper.getIpAddress());
                log.setLevel(loggingEventWrapper.getLevel());
                log.setLogDt(new Date(loggingEventWrapper.getTimeStamp()));
                log.setLoggerName(loggingEventWrapper.getLogger());
                log.setMessage(loggingEventWrapper.getMessage());
                log.setSystemType(loggingEvent.getMDC("system_type") + "");
                String user = loggingEvent.getMDC("user") + "";
                if (StringUtils.isBlank(user) || "null".equals(user)) {
                    user = "游客";
                }
                log.setOperater(user);
                logService.insert(log, null);
                System.out.println("===========日志入库完成================");
            } catch (final JMSException e) {
                System.err.print(e.getMessage());
            } catch (Exception e) {
                System.err.print(e.getMessage());
            }
        }
    }
}
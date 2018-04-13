package com.anzy.frame.jms;

import org.springframework.stereotype.Component;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.MessageListener;

/**
 * Created by anzy on 2018/4/12.
 */
@Component
public class JMSExceptionListener implements ExceptionListener {
    @Override
    public void onException(JMSException exception) {
        System.err.println("there is a problem with the connection");
        System.out.println("wait for reestablish connection");
        establishConn();
    }
    private void establishConn() {
//        conn = JNDIUtil.crateQueueConnection();
//        try {
//            conn.setExceptionListener(this);
//        } catch (JMSException e) {
//            e.printStackTrace();
//        }
    }

}
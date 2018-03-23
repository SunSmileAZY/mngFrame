package com.anzy.frame.mq;

import com.alibaba.fastjson.JSONObject;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by anzy on 2018/2/27.
 */
public class M2Producer {

    public M2Producer(){

    }

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic("topic");

            MessageProducer producer = session.createProducer(destination);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("commKey", "send");
            jsonObject.put("id", "222");
            jsonObject.put("pId", "00ec55041f7c4534a4b6740b9187cf5d");
            jsonObject.put("key", "222_00ec55041f7c4534a4b6740b9187cf5d");
            jsonObject.put("items", "json对象");
            jsonObject.put("code", "equipment");
            for (int i = 0; i < 1; i++) {
                System.out.println("send...messageAA --->" + jsonObject);
                TextMessage message = session.createTextMessage(jsonObject.toJSONString());
                // 通过生产者发出消息
                producer.send(message);
            }

            session.commit();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

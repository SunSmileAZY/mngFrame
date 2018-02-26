/**
 * Created by anzy on 2018/2/6.
 */

import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;
public class Test {
    public static final String brokerList = "47.94.233.239:9092";
    public static final String topic = "accesslog";

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("serializer.class", "kafka.serializer.StringEncoder");
        properties.put("metadata.broker.list", brokerList);

        ProducerConfig config = new ProducerConfig(properties);
        kafka.javaapi.producer.Producer producer = new kafka.javaapi.producer.Producer<Integer, String>(config);

        String message = getMessage(1 * 1024 * 1024);

        for(int i=0;i<3;i++) {
            KeyedMessage<Integer, String> keyedMessage = new KeyedMessage<Integer, String>(topic, message);
            producer.send(keyedMessage);
            System.out.println("=============================");
        }


    }

    public static String getMessage(int msgSize) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<msgSize;i++) {
            stringBuilder.append("x");
        }
        return stringBuilder.toString();
    }

}

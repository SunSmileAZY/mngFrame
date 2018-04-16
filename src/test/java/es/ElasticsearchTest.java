package es;

/**
 * Created by anzy on 2018/4/16.
 */

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Elasticsearch的基本测试
 * 刚开始报 java.lang.NoClassDefFoundError: com/fasterxml/jackson/core/filter/TokenFilte
 * 在pom中去掉引入的com.fasterxml.就好了
 *
 * @ClassName: ElasticsearchTest1
 * @author sunt
 * @date 2017年11月22日
 * @version V1.0
 */
public class ElasticsearchTest {

    private Logger logger = LoggerFactory.getLogger(ElasticsearchTest.class);

    public final static String HOST = "172.25.7.18";

    public final static int PORT = 9300;//http请求的端口是9200，客户端是9300

    /**
     * 测试Elasticsearch客户端连接
     * @Title: test1
     * @author sunt
     * @date 2017年11月22日
     * @return void
     * @throws UnknownHostException
     */
    @SuppressWarnings("resource")
    @Test
    public void test1() throws UnknownHostException {
        //创建客户端
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddresses(
                new InetSocketTransportAddress(InetAddress.getByName(HOST),PORT));
        logger.debug("Elasticsearch connect info:" + client.toString());
        //关闭客户端
        client.close();
    }
}
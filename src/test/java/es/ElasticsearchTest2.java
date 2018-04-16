package es;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 为了简化代码，我们在修改Junit测试类，在方法执行之前连接Elasticsearch，
 * 方法调用之后自动执行关闭Elasticsearch，通过@Before和@After注解实现
 * <p>
 * Created by anzy on 2018/4/16.
 */
public class ElasticsearchTest2 {

    private Logger logger = LoggerFactory.getLogger(ElasticsearchTest2.class);

    public final static String HOST = "localhost";

    public final static int PORT = 9300; //http请求的端口是9200，客户端是9300

    private TransportClient client = null;

    /**
     * 获取客户端连接信息
     *
     * @return void
     * @Title: getConnect
     * @author anzy
     * @date 2017年11月23日
     */
    @SuppressWarnings({"resource", "unchecked"})
    @Before
    public void getConnect() throws UnknownHostException {
        client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddresses(
                new InetSocketTransportAddress(InetAddress.getByName(HOST), PORT));
        logger.info("连接信息:" + client.toString());
    }

    /**
     * 创建索引库
     *
     * @return void
     * 需求:创建一个索引库为：msg消息队列,类型为：tweet,id为1
     * 索引库的名称必须为小写
     * @throws IOException
     * @Title: addIndex1
     * @author anzy
     * @date 2017年11月23日
     */
    @Test
    public void addIndex1() throws IOException {
        IndexResponse response = client.prepareIndex("msg", "tweet", "1").setSource(XContentFactory.jsonBuilder()
                .startObject().field("userName", "张三")
                .field("sendDate", new Date())
                .field("msg", "你好李四1")
                .endObject()).get();

        logger.info("索引名称:" + response.getIndex() + "\n类型:" + response.getType()
                + "\n文档ID:" + response.getId() + "\n当前实例状态:" + response.status());
    }

    /**
     * 添加索引:传入json字符串
     *
     * @return void
     * @Title: addIndex2
     * @author anzy
     */
    @Test
    public void addIndex2() {
        String jsonStr = "{" +
                "\"userName\":\"张三\"," +
                "\"sendDate\":\"2017-11-30\"," +
                "\"msg\":\"你好李四\"" +
                "}";
        IndexResponse response = client.prepareIndex("weixin", "tweet").setSource(jsonStr, XContentType.JSON).get();
        logger.info("json索引名称:" + response.getIndex() + "\njson类型:" + response.getType()
                + "\njson文档ID:" + response.getId() + "\n当前实例json状态:" + response.status());

    }
    /**
     * 创建索引-传入Map对象
     * @Title: addIndex3
     * @author anzy
     * @return void
     */
    @Test
    public void addIndex3() {
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("userName", "张三");
        map.put("sendDate", new Date());
        map.put("msg", "你好李四");

        IndexResponse response = client.prepareIndex("momo", "tweet").setSource(map).get();

        logger.info("map索引名称:" + response.getIndex() + "\n map类型:" + response.getType()
                + "\n map文档ID:" + response.getId() + "\n当前实例map状态:" + response.status());
    }
    /**
     * 传递json对象
     * 需要添加依赖:gson
     * @Title: addIndex4
     * @author anzy
     * @return void
     */
    @Test
    public void addIndex4() {
//        JsonObject jsonObject = new JsonObject();
//        jsonObject.addProperty("userName", "张三");
//        jsonObject.addProperty("sendDate", "2017-11-23");
//        jsonObject.addProperty("msg","你好李四");
//
//        IndexResponse response = client.prepareIndex("qq", "tweet").setSource(jsonObject, XContentType.JSON).get();
//
//        logger.info("jsonObject索引名称:" + response.getIndex() + "\n jsonObject类型:" + response.getType()
//                + "\n jsonObject文档ID:" + response.getId() + "\n当前实例jsonObject状态:" + response.status());
    }

    /**
     * 从索引库获取数据
     * @Title: getData1
     * @author anzy
     * @date 2017年11月23日
     * @return void
     */
    @Test
    public void getData1() {
        GetResponse getResponse = client.prepareGet("msg", "tweet", "1").get();
        logger.info("索引库的数据:" + getResponse.getSourceAsString());
    }
    /**
     * 更新索引库数据
     * @Title: updateData
     * @author anzy
     * @return void
     */
    @Test
    public void updateData() {
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("userName", "张三");
        map.put("sendDate", new Date());
        map.put("msg", "你好李四更新");
        UpdateResponse updateResponse = client.prepareUpdate("msg", "tweet", "1")
                .setDoc(map, XContentType.JSON).get();

        logger.info("updateResponse索引名称:" + updateResponse.getIndex() + "\n updateResponse类型:" + updateResponse.getType()
                + "\n updateResponse文档ID:" + updateResponse.getId() + "\n当前实例updateResponse状态:" + updateResponse.status());
    }

    /**
     * 根据索引名称，类别，文档ID 删除索引库的数据
     * @Title: deleteData
     * @author anzy
     * @return void
     */
    @Test
    public void deleteData() {
        DeleteResponse deleteResponse = client.prepareDelete("msg", "tweet", "1").get();

        logger.info("deleteResponse索引名称:" + deleteResponse.getIndex() + "\n deleteResponse类型:" + deleteResponse.getType()
                + "\n deleteResponse文档ID:" + deleteResponse.getId() + "\n当前实例deleteResponse状态:" + deleteResponse.status());
    }

    /**
     * 关闭连接
     *
     * @return void
     * @Title: closeConnect
     * @author anzy
     * @date 2017年11月23日
     */
    @After
    public void closeConnect() {
        if (null != client) {
            logger.info("执行关闭连接操作...");
            client.close();
        }
    }
}

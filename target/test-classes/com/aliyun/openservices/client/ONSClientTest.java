//package com.aliyun.openservices.client;
//
//
//import com.aliyun.openservices.ons.api.*;
//import com.aliyun.openservices.ons.api.bean.ConsumerBean;
//import com.aliyun.openservices.ons.api.bean.ProducerBean;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.Properties;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:context.xml"})
//public class ONSClientTest extends Container {
//    private final static String TOPIC = "topic-ons-test";
//    private final static String MESSAGE_TYPE = "NM-ons-test";
//
//    private static String messageId;
//
//    @Autowired
//    private ProducerBean producer;
//    @Autowired
//    protected ConsumerBean consumer;
//
//    @Test
//    public void onsClientTest() {
//        Message message = new Message();
//        /**
//         * 必选字段:topic,tag,body
//         */
//        message.setTopic(TOPIC);
//        message.setTag(MESSAGE_TYPE);
//        try {
//             /**
//             * Body需要传入Byte数组，请自行完成序列化/反序列化
//             * 推荐kryo, fastjson, hessian, 序列化性能参见https://github.com/eishay/jvm-serializers/wiki
//             */
//            message.setBody("中文 english test".getBytes("UTF-8")); //消息体
//
//            /**
//             * 可选字段：key, userProperties
//             */
//            message.setKey("123456789"); //消息轨迹查询检索关键字。例如交易的消息可以设置订单号(bizOrderId)
//
//            Properties userProperties = new Properties();
//            userProperties.setProperty("key", "value");
//            message.setUserProperties(userProperties); //用户自定义属性
//
//            /**
//             * 发送成功则返回SendResult，失败则抛异常
//             */
//            SendResult sendResult = producer.send(message);
//            Assert.assertNotNull(sendResult.getMessageId());
//            messageId = sendResult.getMessageId();
//
//
//            /**
//             * 等待5秒，保证消息能够被收到
//             */
//            Thread.sleep(5000);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//    public static class MessageListenerDemo implements MessageListener {
//        public Action consume(Message message, ConsumeContext context) {
//            if (dealWithMessage(message)) {
//                //消费成功
//                return Action.CommitMessage;
//            } else {
//                //消费失败，返回后消息会被重投
//                return Action.ReconsumeLater;
//            }
//        }
//
//        /**
//         * 处理消息
//         *
//         * @param message 消息实体
//         * @return 消息是否处理成功
//         */
//        private boolean dealWithMessage(Message message) {
//            Assert.assertNotNull(message);
//            Assert.assertEquals(message.getMsgID(), messageId);
//            return true;
//        }
//
//    }
//
//}
package com.alibaba.ons.message.example.producer;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.SendResult;
import com.aliyun.openservices.ons.api.bean.ProducerBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MQProducer4Spring {
    /**
     * 启动测试之前请修改配置文件:resources/producer/producer.xml
     * 以及如下 XXX
     */
    private static final String TOPIC = "XXX";
    private static final String TAG = "mq_test_tag";


    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("producer/producer.xml");
        ProducerBean producer = (ProducerBean) ctx.getBean("producer");
        System.out.println("Producer Started");

        for (int i = 0; i < 10; i++) {
            Message message = new Message(TOPIC, TAG, "mq send transaction message test".getBytes());
            SendResult sendResult = producer.send(message);
            if (sendResult != null) {
                System.out.println(new Date() + " Send mq message success! Topic is:" + TOPIC + "msgId is: " + sendResult.getMessageId());
            }
        }
    }


}

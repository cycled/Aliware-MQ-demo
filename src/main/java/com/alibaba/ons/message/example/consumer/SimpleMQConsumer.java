/**
 * Copyright (C) 2010-2016 Alibaba Group Holding Limited
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.ons.message.example.consumer;

import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.PropertyKeyConst;

import java.util.Properties;

/**
 * @author jixiang.jjx
 */
public class SimpleMQConsumer {
    /**
     * 启动测试之前请替换如下 XXX 为您的配置
     */
    private static final String TOPIC = "XXX";
    private static final String CONSUMER_ID = "XXX";
    private static final String ACCESS_KEY = "XXX";
    private static final String SECRET_KEY = "XXX";
    private static final String TAG = "mq_test_tag";

    public static void main(String[] args) {
        Properties consumerProperties = new Properties();
        consumerProperties.setProperty(PropertyKeyConst.ConsumerId, CONSUMER_ID);
        consumerProperties.setProperty(PropertyKeyConst.AccessKey, ACCESS_KEY);
        consumerProperties.setProperty(PropertyKeyConst.SecretKey, SECRET_KEY);
        consumerProperties.setProperty(PropertyKeyConst.ONSAddr, "http://onsaddr-internet.aliyun.com/rocketmq/nsaddr4client-internet");
        Consumer consumer = ONSFactory.createConsumer(consumerProperties);
        consumer.subscribe(TOPIC, TAG, new MessageListenerImpl());
        consumer.start();
        System.out.println("Consumer start success.");

        //等待固定时间防止进程退出
        try {
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

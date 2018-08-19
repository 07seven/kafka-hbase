
package com.seven.kafka;



public interface KafkaProperties {
    final static String zkConnect = "node-1:2181";
    final static String groupId = "group1";
    final static String topic = "topc1";
    final static String kafkaServerURL="ndoe-1";
    final static int kafkaSeverPort = 9092;
    final static int kafkaProducerBufferSize = 64*1024;
    final static int connectionTimeOut = 20000;
    final static int reconnectInterval = 10000;
    final static String topic2 = "topic2";
    final static String topic3 = "topic3";
    final static String clientId = "SimpleConsumerDemoClient";
}

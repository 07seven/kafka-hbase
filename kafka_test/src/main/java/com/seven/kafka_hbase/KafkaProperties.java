package com.seven.kafka_hbase;

/**
 * @Auther: Seven Dong
 * @Date: 2018/8/3 10:47
 * @Description: 认知的海洋越大，无知的海岸线越长
 * consumer的配置文件
 */
public interface KafkaProperties {
    final static String zkConnect = "node-1:2181,node-2:2181,node-3:2181";
    final static String groupId = "group1";
    final static String topic = "test3";
    final static String kafkaServerURL = "node-3";
    final static int kafkaProducerBufferSize = 64 * 1024;
    final static int connectionTimeOut = 20000;
    final static int reconnectInterval = 10000;
    final static String clientId = "SimpleConsumerDemoClient";

}

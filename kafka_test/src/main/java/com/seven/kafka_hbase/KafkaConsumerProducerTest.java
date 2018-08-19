package com.seven.kafka_hbase;

/**
 * @Auther: Seven Dong
 * @Date: 2018/8/3 11:30
 * @Description: 认知的海洋越大，无知的海岸线越长
 */
public class KafkaConsumerProducerTest {
    public static void main(String[] args) {
        KafkaConsumer consumerThread = new KafkaConsumer(KafkaProperties.topic);
        consumerThread.start();
    }

}

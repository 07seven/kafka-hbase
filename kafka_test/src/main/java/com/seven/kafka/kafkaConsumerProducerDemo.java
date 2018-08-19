package com.seven.kafka;

public class kafkaConsumerProducerDemo {
    public static void main(String[] args) {
        KafkaProducer producer = new KafkaProducer(KafkaProperties.topic);
        producer.start();
        KakfaConsumer consumer = new KakfaConsumer(KafkaProperties.topic);
        consumer.start();
    }
}

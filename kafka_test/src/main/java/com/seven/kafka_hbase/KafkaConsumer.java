package com.seven.kafka_hbase;

import com.seven.kafka.KafkaProperties;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


/**
 * @Auther: Seven Dong
 * @Date: 2018/8/3 09:29
 * @Description: 认知的海洋越大，无知的海岸线越长
 * 创建一个consumer消费数据到hbase中
 */
public class KafkaConsumer extends Thread {
    private final ConsumerConnector consumer;
    private final String topic;

    public KafkaConsumer(String topic) {
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(createConsumerConfig());
        this.topic = topic;
    }

    private  static ConsumerConfig createConsumerConfig(){
        Properties props = new Properties();
        props.put("zookeeper.connect",KafkaProperties.zkConnect);
        props.put("group.id",KafkaProperties.groupId);
        props.put("zookeeper.session.timeout.ms","40000");
        props.put("zookeeper.sync.time.ms","20");
        props.put("auto.commit.interval.ms","100");
        return new ConsumerConfig(props);
    }

    @Override
    public void run(){
        HashMap<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic,new Integer(1));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);
        ConsumerIterator<byte[], byte[]> it = stream.iterator();
        HBaseUtils hbase = new HBaseUtils();
        while (it.hasNext()){
            System.out.println("receive:"+new String(it.next().message()));
            try {
                hbase.put(new String(it.next().message()));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }










}

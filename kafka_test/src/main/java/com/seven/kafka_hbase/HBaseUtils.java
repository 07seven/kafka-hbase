package com.seven.kafka_hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.Random;

/**
 * @Auther: Seven Dong
 * @Date: 2018/8/3 09:42
 * @Description: 认知的海洋越大，无知的海岸线越长
 * 创建一个HBaseUtil来指定要连接的Hbase数据库
 */
public class HBaseUtils {
    public void put(String string) throws IOException {
        //设置HBase数据库的连接配置参数
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum","node-1:2181,node-2:2181,node-3:2181");
        //conf.set("hbase.zookeeper.property.clientPort","42182");
        Random random = new Random();
        long a = random.nextInt(1000000000);
        String tableName = "emp";
        String rowkey = "rowkey"+a;
        String columnFamily = "basicinfo";
        String column = "empname";
        HTable table = new HTable(conf, tableName);
        Put put = new Put(Bytes.toBytes(rowkey));
        put.add(Bytes.toBytes(columnFamily),Bytes.toBytes(column),Bytes.toBytes(string));
        table.put(put);//放入表
        table.close();//释放资源


    }
}

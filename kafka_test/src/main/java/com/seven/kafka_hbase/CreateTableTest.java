package com.seven.kafka_hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;

/**
 * @Auther: Seven Dong
 * @Date: 2018/8/3 09:15
 * @Description: 认知的海洋越大，无知的海岸线越长
 * 通过API创建hbase数据库表
 */
public class CreateTableTest {
    public static void main(String[] args) throws Exception{
        //设置hbase数据库的连接配置参数
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum","node-1:2181,node-2:2181,node-3:2181");
        //conf.set("hbase.zookeeper.property.clientPort","42182");
        String tableName = "emp";
        String[] family = {"basicinfo","deptinfo"};
        HBaseAdmin hBaseAdmin = new HBaseAdmin(conf);
        //创建表对象
        HTableDescriptor hbaseTableDesc = new HTableDescriptor(tableName);
        for (int i = 0; i < family.length; i++){
            //设置表字段
            hbaseTableDesc.addFamily(new HColumnDescriptor(family[i]));
        }
        //判断表是否存在，不存在则创建，存在则打印提示信息
        if (hBaseAdmin.tableExists(tableName)){
            System.out.println("TableExists!");
            System.exit(0);
        }else {
            hBaseAdmin.createTable(hbaseTableDesc);
            System.out.println("Create table Success!");
        }

    }

}

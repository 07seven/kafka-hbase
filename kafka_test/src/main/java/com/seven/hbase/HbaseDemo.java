package com.seven.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @Auther: Seven Dong
 * @Date: 2018/8/2 16:32
 * @Description: 认知的海洋越大，无知的海岸线越长
 */
public class HbaseDemo {
    private Configuration conf  = null;
    @Before
    public void init(){
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum","node-1:2181,node-2:2181,node-3:2181");
    }

    @Test
    public void testDrop() throws Exception{

      HBaseAdmin admin = new HBaseAdmin(conf);
      admin.disableTable("account");
      admin.deleteTable("account");
      admin.close();
    }

    @Test
    public void testPut() throws Exception{
        HTable table = new HTable(conf, "person_info");
        Put p = new Put(Bytes.toBytes("person_rk_bj_zhang_000002"));
        p.add("base_info".getBytes(), "name".getBytes(), "zhangwuji".getBytes());
        table.put(p);
        table.close();
    }

    @Test
    public void testDel() throws Exception{
        HTable table = new HTable(conf, "user1");
        Delete del = new Delete(Bytes.toBytes("rk0001"));
        del.deleteColumn(Bytes.toBytes("data"),Bytes.toBytes("pic"));
        table.delete(del);
        table.close();
    }

    @Test
    public void testGet() throws Exception{

        HTable table = new HTable(conf, "A2011002LACCOUNT");
        Get get = new Get(Bytes.toBytes("1132040108001"));
        get.setMaxVersions(5);
        Result result = table.get(get);
        List<Cell> cells = result.listCells();
        for (Cell c : cells){

        }
        List<KeyValue> kvs = result.list();
        for (KeyValue kv : kvs){
            String family = new String(kv.getFamily());
            System.out.println(family);
            String qualifier = new String(kv.getQualifier());
            System.out.println(qualifier);
            String s = new String(kv.getValueArray());
            System.out.println(s);
        }
        table.close();
    }



}

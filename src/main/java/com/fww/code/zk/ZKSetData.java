package com.fww.code.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

/**
 * Created by @author fww on 2018/11/2.
 */
public class ZKSetData {

    private static ZooKeeper zk;

    private static ZooKeeperConnection conn;

    public static void main(String[] args) {
        String path = "/MyFirstZnode";
        byte[] data = "Success".getBytes(); //Assign data which is to be updated.

        try {
            conn = new ZooKeeperConnection();
            zk = conn.connect("localhost");
            update(path, data); // Update znode data to the specified path
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void update(String path, byte[] data) throws KeeperException, InterruptedException {
        zk.setData(path, data, zk.exists(path, true).getVersion());
    }
}

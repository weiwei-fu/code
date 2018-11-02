package com.fww.code.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by @author fww on 2018/11/2.
 */
public class ZKCreater {

    private static ZooKeeper zooKeeper;

    private static ZooKeeperConnection zooKeeperConnection;

    public static void create(String path, byte[] data) throws KeeperException, InterruptedException {
        zooKeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public static void main(String[] args) {
        String path = "/MyFirstZnode";
        byte[] description = "test for zookeeper".getBytes();

        try {
            zooKeeperConnection = new ZooKeeperConnection();
            zooKeeper = zooKeeperConnection.connect("127.0.0.1:2181");
            create(path,description);
            zooKeeperConnection.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}

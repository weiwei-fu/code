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

    private static ZookeeperConnection zookeeperConnection;

    public static void create(String path, byte[] data) throws KeeperException, InterruptedException {
        zooKeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public static void main(String[] args) {
        String path = "/fww";
        byte[] description = "test for zookeeper".getBytes();

        try {
            zookeeperConnection = new ZookeeperConnection();
            zooKeeper = zookeeperConnection.connect("127.0.0.1:2181");
            create(path,description);
            zookeeperConnection.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}

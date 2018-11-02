package com.fww.code.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * Created by @author fww on 2018/11/2.
 */
public class ZkExists {

    private static ZooKeeper zooKeeper;

    private static ZookeeperConnection conn;

    public static void main(String[] args) {
        String path = "/fwwtest1";

        try {
            conn = new ZookeeperConnection();
            zooKeeper = conn.connect("localhost");

            Stat stat = znode_exists(path);

            if(stat != null) {
                System.out.println("Node exists and the node version is " +
                        stat.getVersion());
            } else {
                System.out.println("Node does not exists");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }

    private static Stat znode_exists(String path) throws KeeperException, InterruptedException {
        return zooKeeper.exists(path,true);
    }
}

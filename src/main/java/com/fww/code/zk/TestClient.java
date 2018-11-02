package com.fww.code.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by @author fww on 2018/11/2.
 */
public class TestClient extends Thread implements Watcher {
    public ZooKeeper zooKeeper;
    private static final int SESSION_TIME_OUT = 2000;
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public void connectToZookeeper(String host) throws IOException, InterruptedException {
        zooKeeper = new ZooKeeper(host, SESSION_TIME_OUT, this);
        countDownLatch.await();
        System.out.println("zookeeper connect ok.e");
    }

    public byte[] getNodeValue(String path) throws KeeperException, InterruptedException {
        System.out.println(this.zooKeeper.getState().isAlive());
        return this.zooKeeper.getData(path, true, null);
    }

    public void closeZookeeperConnection() throws InterruptedException {
        zooKeeper.close();
    }

    public String createNode(String path, byte data[]) throws KeeperException, InterruptedException {
        return this.zooKeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public List<String> getChildren(String path) throws KeeperException, InterruptedException {
        return this.zooKeeper.getChildren(path, false);
    }

    public Stat setDada(String path, byte[] data, int version) throws KeeperException, InterruptedException {
        return this.zooKeeper.setData(path, data, version);
    }

    public void deleteNode(String path, int version) throws KeeperException, InterruptedException {
        this.zooKeeper.delete(path, version);
    }


    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("监听到事件 ： " + watchedEvent.getState());
        System.out.println("事件类型: " + watchedEvent.getType());
        try {
            this.getNodeValue("/dubbo/com.altamob.geoip.api.GeoIpService/consumers");
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(watchedEvent.getState() == Event.KeeperState.SyncConnected){
            System.out.println("watcher received event.");
            countDownLatch.countDown();
        }//if
    }

    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws IOException, InterruptedException, KeeperException {
        TestClient testClient = new TestClient();

        String host = "127.0.0.1:2181";
        testClient.connectToZookeeper(host);

        testClient.start();
        byte[] data = testClient.getNodeValue("/dubbo/com.altamob.geoip.api.GeoIpService/consumers");
        String dataOfString = new String(data);
        System.out.println("dataOfString = " + dataOfString);
//
////        testClient.createNode("/zk_book", "books".getBytes());
//        byte []data1  = testClient.getNodeValue("/zk_book");
//        String data1OfString = new String(data1);
//        System.out.println("data1OfString = " + data1OfString);


//        testClient.closeZookeeperConnection();
    }
}
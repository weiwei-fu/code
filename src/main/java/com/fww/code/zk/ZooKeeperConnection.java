package com.fww.code.zk;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by @author fww on 2018/11/2.
 */
public class ZooKeeperConnection {

    private ZooKeeper zooKeeper;

    final CountDownLatch connectedSignal = new CountDownLatch(1);

    public ZooKeeper connect(String host) throws InterruptedException, IOException {
        zooKeeper = new ZooKeeper(host, 500, watchedEvent -> {
            if (watchedEvent.getState()== Watcher.Event.KeeperState.SyncConnected) {
                connectedSignal.countDown();
            }
        });
        connectedSignal.await();
        return zooKeeper;
    }

    public void close() throws InterruptedException {
        zooKeeper.close();
    }

}

package com.chz.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hongzhen.cao on 2019/7/24.
 */
public class DeadLockInstance {

    private static DeadLockInstance deadLockA = new DeadLockInstance();

    private static DeadLockInstance deadLockB = new DeadLockInstance();

    public static void main(String[] args) {


        DeadLockInstance deadLockInstance = new DeadLockInstance();

        ExecutorService executorService = Executors.newCachedThreadPool();

            executorService.execute(() -> {
                synchronized (deadLockInstance.deadLockA) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("ex1 get deadLockA");
                    synchronized (deadLockInstance.deadLockB) {
                        System.out.println("ex1 get dealLockB");
                    }
                }
            });

            executorService.execute(() -> {
                synchronized (deadLockInstance.deadLockB) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("ex2 get deadLockB");
                    synchronized (deadLockInstance.deadLockA) {
                        System.out.println("ex2 get deadLockA");
                    }
                }
            });
        executorService.shutdown();
    }
}

package com.chz.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ConditionsCase {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        Condition condition =  lock.newCondition();

        new Thread(() -> {
            try {
                lock.lock();
                log.info("wait signal");
                condition.await();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
            log.info("get signal");
            lock.unlock();
        }).start();

        new Thread(() -> {
            lock.lock();
            log.info("get lock");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            condition.signalAll();
            log.info("send signal");
            lock.unlock();
        }).start();
    }
}

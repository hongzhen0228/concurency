package com.chz.lock;

import com.chz.annoations.ThreadSafe;
import com.chz.lock.sych.SynchronizedCountCase;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@ThreadSafe
public class ReentrantLockCase {

    public static int clientTotal = 5000;

    public static int threadTotal = 200;

    public static int count = 0;

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count{}",count);

    }

    public static void add() {
        synchronized (SynchronizedCountCase.class) {
            lock.lock();
            try {
                count ++;
            } finally {
                lock.unlock();
            }
        }
    }


}

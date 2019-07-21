package com.chz.threadsafe.atomic;

import com.chz.threadsafe.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@ThreadSafe
public class AtomicBooleanCase  {

    public static int clientTotal = 5000;

    public static int threadTotal = 200;

    public static int count = 0;

    private static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("result{}", atomicBoolean.get());

    }

    private static void test() {
        if (atomicBoolean.compareAndSet(false,true)) {
            log.info("result{},","executed");
        }
    }
}

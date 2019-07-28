package com.chz.lock.sych;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedCase {

    public void test1(int j) {
        synchronized (SynchronizedCase.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}" ,j,i);

            }
        }
    }

    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}",j,i);

        }
    }

    public static void main(String[] args) {
        SynchronizedCase synchronizedCase = new SynchronizedCase();
        SynchronizedCase synchronizedCase1 = new SynchronizedCase();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> {
            synchronizedCase.test2(1);
        });
        executorService.execute(() -> {
            synchronizedCase.test2(2);
        });
    }
}

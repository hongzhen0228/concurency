package com.chz.unsafe;

import com.chz.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by hongzhen.cao on 2019/7/22.
 */
@Slf4j
@NotThreadSafe
public class SimpleDateFormatCase {

    public static int clientTotal = 5000;

    public static int threadTotal = 200;

    private static String format = "yyyyMMdd";

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("simpleDateFormat{}");
    }

    public static void update() {
        try {
            simpleDateFormat.parse("20190722");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

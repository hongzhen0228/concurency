package com.chz.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class FutrueCase {

    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            log.info("do something");
            Thread.sleep(5000);
            return "done";
        }
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(new MyCallable());
        log.info("do something in main");
        Thread.sleep(1000);
        String result = submit.get();
        System.out.println(result);
    }
}

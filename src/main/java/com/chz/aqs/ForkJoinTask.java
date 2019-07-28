package com.chz.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

@Slf4j
public class ForkJoinTask extends RecursiveTask<Integer> {

    public static final int threadHold = 2;

    private int start;

    private int end;

    public ForkJoinTask(int start, int end) {
        this.start = start;
        this.end = end;

    }
    @Override
    protected Integer compute() {
        int sum = 0;

        boolean canCompute = (end - start) <= threadHold;

        if (canCompute) {
            for (int i = start; i <= end; i ++) {
                sum += i;
            }
        } else {
            // 如果大于域值，则分裂成2个自任务来做
            int middle = (start + end) / 2;
            ForkJoinTask leftTask = new ForkJoinTask(start, middle);
            ForkJoinTask rightTask = new ForkJoinTask(middle + 1, end);

            // 执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待任务执行结束并返回结果
            Integer leftResult = leftTask.join();
            Integer rightResult = rightTask.join();

            sum = leftResult + rightResult;

        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkJoinTask forkJoinTask = new ForkJoinTask(0,100);

        java.util.concurrent.ForkJoinTask result = forkJoinPool.submit(forkJoinTask);

        try {
            log.info("result:{}",result.get());
        } catch (Exception e) {
            log.error("exception",e);
        }
    }
}

package com.chz.atomic;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;
@Slf4j
public class AtomicReferenceCase {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);


    public static void main(String[] args) {
        count.compareAndSet(0,1);
        count.compareAndSet(1,2);
        count.compareAndSet(2,3);
        log.info("count{}",count.get());
    }
}

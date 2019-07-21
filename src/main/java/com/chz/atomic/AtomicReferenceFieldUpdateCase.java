package com.chz.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
@Slf4j
public class AtomicReferenceFieldUpdateCase {


    private static AtomicIntegerFieldUpdater updater = AtomicIntegerFieldUpdater.newUpdater(AtomicReferenceFieldUpdateCase.class,"count");

    private static AtomicReferenceFieldUpdateCase atomicReferenceFieldUpdateCase = new AtomicReferenceFieldUpdateCase();

    private volatile int count = 100;

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        if (updater.compareAndSet(atomicReferenceFieldUpdateCase,100,120)){
            log.info("update success,{}",atomicReferenceFieldUpdateCase.getCount());
        }
        if (updater.compareAndSet(atomicReferenceFieldUpdateCase,100,120)){
            log.info("update success,{}",atomicReferenceFieldUpdateCase.getCount());
        } else {
            log.error("update failed,{}",atomicReferenceFieldUpdateCase.getCount());
        }


    }



}

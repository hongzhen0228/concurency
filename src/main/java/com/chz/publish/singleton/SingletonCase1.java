package com.chz.publish.singleton;

import com.chz.threadsafe.annoations.NotThreadSafe;

/**
 * 懒汉模式
 */
@NotThreadSafe
public class SingletonCase1 {

    private SingletonCase1() {

    }

    private static SingletonCase1 instance = null;

    public static SingletonCase1 getInstance() {
        if (instance == null) {
            instance = new SingletonCase1();
        }
        return instance;
    }
}

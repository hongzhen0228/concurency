package com.chz.publish.singleton;

import com.chz.annoations.ThreadSafe;

/**
 * 饿汉模式
 */
@ThreadSafe
public class SingletonCase2 {

    private SingletonCase2() {

    }

    private static SingletonCase2 instance = new SingletonCase2();

    public static SingletonCase2 getInstance() {
        return instance;
    }
}

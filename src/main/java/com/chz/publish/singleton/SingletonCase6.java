package com.chz.publish.singleton;

import com.chz.threadsafe.annoations.ThreadSafe;

/**
 * 饿汉模式
 */
@ThreadSafe
public class SingletonCase6 {

    private SingletonCase6() {

    }

    /**
     * 写静态代码块时候，注意顺序
     * 1.
     */
    private static SingletonCase6 instance = null;

    /**
     * 2.
     */
    static {
        instance = new SingletonCase6();
    }


    public static SingletonCase6 getInstance() {
        return instance;
    }


    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());

    }
}

package com.chz.publish.singleton;

import com.chz.threadsafe.annoations.NotThreadSafe;
import com.chz.threadsafe.annoations.ThreadSafe;

/**
 * 懒汉模式
 */
@ThreadSafe
public class SingletonCase3 {

    private SingletonCase3() {

    }

    private static SingletonCase3 instance = null;

    public synchronized static SingletonCase3 getInstance() {
        if (instance == null) {
            instance = new SingletonCase3();
        }
        return instance;
    }
}

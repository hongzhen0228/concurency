package com.chz.publish.singleton;

import com.chz.annoations.NotThreadSafe;

/**
 * 懒汉模式
 */
@NotThreadSafe
public class SingletonCase4 {

    private SingletonCase4() {

    }

    private static SingletonCase4 instance = null;

    //1.分配对象空间
    //2.初始化对象
    //3.指向


    //JVM和cpu发生了指令重拍

    public synchronized static SingletonCase4 getInstance() {
        if (instance == null) {
            synchronized (SingletonCase4.class) {
                if (instance == null) {
                    instance = new SingletonCase4();
                }
            }
          }
        return instance;
    }
}

package com.chz.publish.singleton;

import com.chz.threadsafe.annoations.NotThreadSafe;

/**
 * 懒汉模式
 */
@NotThreadSafe
public class SingletonCase5 {

    private SingletonCase5() {

    }
    //限制发生指令重排序
    private volatile static SingletonCase5 instance = null;

    //1.分配对象空间
    //2.初始化对象
    //3.指向


    //JVM和cpu发生了指令重拍

    public synchronized static SingletonCase5 getInstance() {
        if (instance == null) {
            synchronized (SingletonCase5.class) {
                if (instance == null) {
                    instance = new SingletonCase5();
                }
            }
          }
        return instance;
    }
}

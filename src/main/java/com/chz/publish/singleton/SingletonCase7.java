package com.chz.publish.singleton;

public class SingletonCase7 {

    private SingletonCase7() {

    }

    public static SingletonCase7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonCase7 singleton;

        Singleton() {
            singleton = new SingletonCase7();
        }

        public SingletonCase7 getInstance() {
            return singleton;
        }

    }
}

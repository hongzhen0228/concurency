package com.chz.aqs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.stream.Stream;

/**
 * Created by hongzhen.cao on 2019/7/22.
 */
public class CountDownLatchCase {

    private static int totalClient = 500;

    private static int totalThread = 5;

    private static CountDownLatch countDownLatch = new CountDownLatch(totalClient);

    private static Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) {

    }


}

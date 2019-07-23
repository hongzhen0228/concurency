package com.chz.deadlock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hongzhen.cao on 2019/7/24.
 */
public class DynamicOrderDeadlock {

    private static final int totalThreads = 5;

    private static final int numAccounts = 5;

    private static final int numIteration = 100000;

    public static void main(String[] args) {
        final Random random = new Random();
        final Account[] accounts = new Account[numAccounts];

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account();
        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThreads; i++) {
            executorService.execute(() -> {
                int fromAcct = random.nextInt(numAccounts);
                int toAcct = random.nextInt(numAccounts);
                int amount = random.nextInt(100);
                try {
                    Account.transferMoney(accounts[fromAcct],accounts[toAcct],amount,fromAcct,toAcct);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}

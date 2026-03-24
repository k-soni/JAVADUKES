package com.ksoni.javadukes.synchronizationConcurrency;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    private Counter count;
    private Lock lock;

    Adder(Counter count, Lock lock) {

        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (Counter.class) {
                this.count.value += i;
            }

        }
    }
}

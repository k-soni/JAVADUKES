package com.ksoni.javadukes.synchronizationConcurrency;

import java.util.concurrent.locks.Lock;

public class Substractor implements Runnable {
    Counter count;
    Lock lock;
    Substractor(Counter count, Lock lock) {
        this.lock = lock;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (Counter.class) {
                this.count.value -= i;
            }
        }
    }
}

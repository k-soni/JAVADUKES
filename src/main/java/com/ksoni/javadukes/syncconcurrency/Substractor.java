package com.ksoni.javadukes.syncconcurrency;

public class Substractor implements Runnable {
    Counter count;

    Substractor(Counter count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            this.count.value -= i;
        }
    }
}

package com.ksoni.javadukes.syncconcurrency;

public class Adder implements Runnable {
    private Counter count;

    Adder(Counter count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            this.count.value += i;
        }
    }
}

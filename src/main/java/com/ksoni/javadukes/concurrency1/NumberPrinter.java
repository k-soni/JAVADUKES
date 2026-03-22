package com.ksoni.javadukes.concurrency1;

public class NumberPrinter implements Runnable {

    int number = 0;

    NumberPrinter(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Number "+this.number+" is processed with "+Thread.currentThread().getName());
    }
}

package com.ksoni.javadukes.synchronizationConcurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Lock lock = new ReentrantLock();

        Adder adder = new Adder(counter,lock);
        Substractor substractor = new Substractor(counter,lock);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(substractor);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count : " + counter.value);

    }

}

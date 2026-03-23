package com.ksoni.javadukes.syncconcurrency;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Adder adder = new Adder(counter);
        Substractor substractor = new Substractor(counter);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(substractor);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count : " + counter.value);

    }

}

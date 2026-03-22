package com.ksoni.javadukes.concurrency1;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrancyMain {
    public static void main(final String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 100 ; i++) {
            NumberPrinter numberPrinter = new NumberPrinter(i);
            executor.submit(numberPrinter);
        }
        // Callable


    }
}

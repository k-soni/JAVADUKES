package com.ksoni.javadukes.concurrency1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableConcurreny {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = Arrays.asList(5,3,1,2,7,8,5,9);

        ExecutorService executors = Executors.newCachedThreadPool();
        MergeSorter mergeSortedList = new MergeSorter(list, executors);

        Future<List<Integer>> res = executors.submit(mergeSortedList);
        System.out.println(res.get());

    }
}

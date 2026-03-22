package com.ksoni.javadukes.concurrency1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MergeSorter implements Callable<List<Integer>> {
    List<Integer> listToSort;
    ExecutorService executorsService;

    MergeSorter(List<Integer> listToSort, ExecutorService executorsService) {
        this.listToSort = listToSort;
        this.executorsService = executorsService;
    }


    @Override
    public List<Integer> call() throws Exception {

        List<Integer> firstHalfList = new ArrayList<>();
        List<Integer> secondHalfList = new ArrayList<>();

        int N = this.listToSort.size();

        if(N <= 1) {
            return this.listToSort;
        }

        for (int i = 0; i < N/2; i++) {
            firstHalfList.add(listToSort.get(i));
        }

        for (int i = N/2; i < N; i++) {
            secondHalfList.add(listToSort.get(i));
        }

        MergeSorter firstSortedList = new MergeSorter(firstHalfList, executorsService);
        MergeSorter secondSorterList = new MergeSorter(secondHalfList, executorsService);

        //call threads

        Future<List<Integer>> firstSortedListFuture = executorsService.submit(firstSortedList);
        Future<List<Integer>> secondSortedListFuture = executorsService.submit(secondSorterList);
        
        List<Integer> firstSortedArray = firstSortedListFuture.get();
        List<Integer> secondSortedArray = secondSortedListFuture.get();
        
        // merge array
        int i = 0; int j = 0;
        List<Integer> mergedSortedList = new ArrayList<>();

        while (i < firstSortedArray.size() && j < secondSortedArray.size()) {
            if(firstSortedArray.get(i) < secondSortedArray.get(j)) {
                mergedSortedList.add(firstSortedArray.get(i));
                i++;
            } else {
                mergedSortedList.add(secondSortedArray.get(j));
                j++;
            }
        }
        
        // push remaining items
        while(i < firstSortedArray.size()) {
            mergedSortedList.add(firstSortedArray.get(i));
            i++;
        }

        while(j < firstSortedArray.size()) {
            mergedSortedList.add(secondSortedArray.get(j));
            j++;
        }
        
        return mergedSortedList;
    }
}

package com.ksoni.javadukes.Heaps;

import java.util.*;

public class RunningMedian {

    public static void main(String[] args) {
        RunningMedian rm = new RunningMedian();
        rm.solve(new int[]{59,64,10,39});
    }

    public int[] solve(int[] A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> C = new ArrayList<>();

        maxHeap.add(A[0]);
        C.add(maxHeap.peek());

        for (int i = 1; i < A.length; i++) {
            if(A[i] > maxHeap.peek()) {
                minHeap.add(A[i]);
            }else {
                maxHeap.add(A[i]);
            }

            int size = maxHeap.size() - minHeap.size();

            if(size == 0) {
                int median = maxHeap.peek();
                C.add(median);
            } else if (size == 2) {
                minHeap.add(maxHeap.poll());
                int median = maxHeap.peek();
                C.add(median);
            } else if (size == 1) {
                int median = maxHeap.peek();
                C.add(median);
            } else {
                maxHeap.add(minHeap.poll());
                int median = maxHeap.peek();
                C.add(median);
            }


        }

        int[] ans = new int[C.size()];
        for (int i = 0; i < C.size(); i++) {
            ans[i] = C.get(i);
            System.out.println(ans[i]);
        }

        return ans;



    }

}

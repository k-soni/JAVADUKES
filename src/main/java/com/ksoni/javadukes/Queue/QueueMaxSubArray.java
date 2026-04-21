package com.ksoni.javadukes.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueMaxSubArray {
    public static void main(String[] args) {

    }

    public void solve(int[] A, int K) {

        int N = A.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[K];


        // process first K elements

        for (int i = 0; i < K; i++) {
            // remove smaller elements
            if(!deque.isEmpty() && A[deque.getLast()] < A[K]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        ans[0] = A[deque.getFirst()];
        int idx = 1;
        //process remaining elements

        for (int i = 1; i < N; i++) {
            // remove smaller elements
            if(!deque.isEmpty() && A[deque.getLast()] < A[i]) {
                deque.removeLast();
            }
            deque.addLast(i);

            if(deque.getFirst() <= i-K) {
                deque.removeFirst();
            }
            ans[idx] = A[deque.getFirst()];
            idx++;

        }

    }

}

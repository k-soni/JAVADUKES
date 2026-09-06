package com.ksoni.javadukes.Heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HeapQueries2 {
    public static void main(String[] args) {

    }

    public int[] solve(int[][] A) {
        List<Integer> heap = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            int q = A[i][1];

            if(q == -1) {
                if(heap.isEmpty()) {
                    ans.add(-1);
                } else {
                    ans.add(heap.get(0));
                    downHeapify(heap);
                }
            } else {
                upheapify(heap, q);
            }
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;

    }

    public void upheapify(List<Integer> heap, int q) {
        heap.add(q);
        int idx = heap.size() - 1;
        while (idx >= 0) {
            int pIdx = (idx - 1)/2;
            if(heap.get(pIdx) > heap.get(idx)) {
                swap(heap, pIdx, idx);
                idx = pIdx;
            } else {
                return;
            }
        }
    }


    public void heapify(List<Integer> heap, int idx) {
        while (2 * idx + 1 < heap.size()) {
            int lc = 2 * idx + 1;
            int rc = 2 * idx + 2;
            int min = Math.min(heap.get(idx), heap.get(lc));
            if(rc < heap.size()) {
                min = Math.min(min, heap.get(rc));
            }

            if(min == heap.get(idx)) {
                return;
            } else if (min == heap.get(lc)) {
                swap(heap, idx, lc);
                idx = lc;
            } else {
                swap(heap, idx, rc);
                idx = rc;
            }
        }
    }

    public void downHeapify(List<Integer> heap) {
        if(heap.size() == 1) {
            heap.clear();
            return;
        }
        swap(heap, 0, heap.size() -1);
        heap.remove(heap.size() - 1);
        heapify(heap, 0);
    }




    public void swap(List<Integer> heap, int pidx, int cidx) {
        int temp = heap.get(pidx);
        heap.set(pidx, heap.get(cidx));
        heap.set(cidx, temp);
    }




}

/**
 * Problem Description
 *
 * You have an empty min heap. You are given an array A consisting of N queries. Let P denote A[i][0] and Q denote A[i][1]. There are two types of queries:
 *
 * P = 1, Q = -1 : Pop the minimum element from the heap.
 * P = 2, 1 <= Q <= 109 : Insert Q into the heap.
 *
 * Return an integer array containing the answer for all the extract min operation. If the size of heap is 0, then extract min should return -1.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 105
 *
 * 1 <= A[i][0] <= 2
 *
 * 1 <= A[i][1] <= 109 or A[i][1] = -1
 *
 *
 *
 * Input Format
 *
 * The only argument A is a 2D integer array
 *
 *
 *
 * Output Format
 *
 * Return an integer array
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [[1, -1], [2, 2], [2, 1], [1, -1]]
 * Input 2:
 *
 * A = [[2, 5], [2, 3], [2, 1], [1, -1], [1, -1]]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * [-1, 1]
 * Output 2:
 *
 * [1, 3]
 *
 * */
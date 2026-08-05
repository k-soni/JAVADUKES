package com.ksoni.javadukes.Heaps;

import java.util.ArrayList;
import java.util.List;

public class HeapQueries {
    public static void main(String[] args) {

    }

    public int[] solve(int[][] A) {
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>(list);

        for (int i = 0; i < A.length; i++) {
            if(A[i][0] > 1) {
                upHeapify(list,A[i][1]);
            } else {
                if(list.isEmpty()) {
                    result.add(-1);
                } else {
                    result.add(list.get(0));
                    downHeapify(list);
                }
            }
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = result.get(i);
        }

        return  ans;

    }

    public void upHeapify(List<Integer> arr,int target) {
        arr.add(target);
        int i = arr.size() - 1;

        while (i > 0) {
            int pi = (i - 1)/2;
            if(arr.get(pi) > arr.get(i)) {
                swap(arr, pi, i);
                i = pi;
            } else {
                break;
            }
        }
    }

    public void swap(List<Integer> arr, int pi, int i) {
        int temp = arr.get(pi);
        arr.set(pi, arr.get(i));
        arr.set(i,temp);
    }

    public void downHeapify(List<Integer> arr) {
        swap(arr, 0, arr.size() - 1);
        arr.remove(arr.size() - 1);

        int i = 0;
        while (2 * i + 1 < arr.size()) {
            int lc = 2 * i + 1;
            int rc = 2 * i + 2;

            int min = Math.min(arr.get(i),  arr.get(lc));
            if(rc < arr.size()) {
                min = Math.min(min, arr.get(rc));
            }

            if(min == arr.get(i)) {
                break;
            }
            if(min == arr.get(lc)) {
                swap(arr, i, lc);
                i = lc;
            } else {
                swap(arr, i, rc);
                i = rc;
            }
        }
    }



}

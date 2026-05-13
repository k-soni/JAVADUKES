package com.ksoni.javadukes.Sorting;

public class CountSort {

    public static void main(String[] args) {

    }

    public int[] solve(int[] A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] ans = new int[A.length];

        for (int num: A) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int range = max - min + 1;

        int[] frequencyArray = new int[range];

        for (int i = 0; i < A.length; i++) {
            frequencyArray[A[i - min]]++;
        }

        int idx = 0;

        for (int i = 0; i < range; i++) {
            for (int j = 0; j < frequencyArray[i]; j++) {
                ans[idx] = i + min;
            }
        }

        return ans;



    }


}

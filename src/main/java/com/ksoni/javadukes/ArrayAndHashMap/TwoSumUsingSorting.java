package com.ksoni.javadukes.ArrayAndHashMap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TwoSumUsingSorting {

    public static void main(String[] args) {

    }

    static class Pair <K,V> {
        K key;
        V value;

        Pair (K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    int[] solve(int[] A, int target) {

        Pair<Integer, Integer>[] arr = new Pair[A.length];
        int[] ans = new int[] {-1,-1};

        for (int i = 0; i < A.length; i++) {
            arr[i] = new Pair<>(A[i],i);
        }

        Arrays.sort(arr, (a,b) -> Integer.compare(a.value, b.value));

        int left = 0;
        int right = arr.length -1;
        while (left < right) {
            int sum = arr[left].value + arr[right].value;
            if(sum == target) {
                return new int[]{arr[left].value, arr[right].value};
            }

            if(sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return ans;

    }
}

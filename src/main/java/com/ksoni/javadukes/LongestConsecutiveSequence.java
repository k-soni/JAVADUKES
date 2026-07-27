package com.ksoni.javadukes;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int ans = longestConsecutiveSequence.solveSorting(new int[]{100,45, 200, 1, 2,3});

        System.out.println(ans);
    }

    public int solveBR(int[] A){
        if(A.length == 0) {
            return 0;
        }

        int longest = 1;

        for (int i = 0; i < A.length; i++) {

            int current = A[i];
            int count = 1;

            while (contains(A, current + 1)){
                current = current + 1;
                count = count +1;
            }

            longest = Math.max(longest,count);

        }

        return longest;

    }

    public int solveSorting(int[] A) {
        Arrays.sort(A);
        int longest = 1;
        int count = 1;
        for (int i = 1; i < A.length; i++) {
            if(A[i] == (A[i-1] + 1)) {
                count++;

            } else {
                longest = Math.max(longest, count);
                count = 1;
            }
        }
        longest = Math.max(longest, count);
        return longest;
    }

    private boolean contains(int[] A, int target) {
        for (int i = 0; i < A.length ; i++) {
                if(A[i] == target) {
                    return true;
                }
        }
        return false;
    }


    public int solve(int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int num: A) {
            set.add(num);
        }

        int longest = 0;

        for (int i = 0; i < A.length; i++) {

            if (!set.contains(A[i] - 1)) {
                int current = A[i];
                int length = 1;

                while (set.contains(A[i] + 1)) {
                    current++;
                    length++;
                }
                longest = Math.max(longest,length);
            }
        }

        return longest;
    }



}

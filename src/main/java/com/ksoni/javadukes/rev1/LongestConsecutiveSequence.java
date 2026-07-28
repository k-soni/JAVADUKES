package com.ksoni.javadukes.rev1;

/*Problem Statement
        Given an unsorted array of integers, return the length of the longest consecutive elements sequence.
        Your algorithm must run in O(n).
 */

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        longestConsecutiveSequence.solve(new int[]{1,2,3,5,6,1,2,3,4,5,6,5,6,7,8});
    }

    public int solve(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int num: A) {
            set.add(num);
        }

        int longest = 0;

        for (int i = 0; i < A.length; i++) {
            if(!set.contains(A[i] - 1)) {

                int count = 1;
                int num = A[i];
                while (set.contains(num + 1)) {
                    count++;
                    num++;
                }
                longest = Math.max(longest, count);
            }
        }
        System.out.println(longest);
        return longest;
    }
}

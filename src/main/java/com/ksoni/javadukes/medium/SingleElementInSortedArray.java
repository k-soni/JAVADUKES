// Given a sorted array of integers A where every element appears twice except
// for one element which appears once, find and return this single element that appears only once.
// Elements which are appearing twice are adjacent to each other.
// NOTE: Users are expected to solve this in O(log(N)) time.

package com.ksoni.javadukes.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleElementInSortedArray {
    public static void main(final String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(13,13,21,21,27,50,50,102,102,108,108,110,110,117,117,120,120,123,123,124,124,132,132,164,164,166,166,190,190,200,200,212,212,217,217,225,225,238,238,261,261,276,276,347,347,348,348,386,386,394,394,405,405,426,426,435,435,474,474,493,493));
        SingleElementInSortedArray singleElementInSortedArray = new SingleElementInSortedArray();
        int res = singleElementInSortedArray.solve(A);
        System.out.println(res);
    }

    public int solve(ArrayList<Integer> A) {

        int N = A.size();


        // edge case
        // 1. check if the first the elemnent is the unique element

        if(!A.get(0).equals(A.get(1))) {
            return A.get(0);
        }

        // 2. check if the last the elemnent is the unique element

        if(!A.get(N-1).equals(A.get(N-2))) {
            return A.get(N-1);
        }

        int left = 0;
        int right = N - 1;
        int aloneElement = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;

            if(mid > 0 && mid < A.size() - 1 && !A.get(mid).equals(A.get(mid+1)) && !A.get(mid).equals(A.get(mid-1))) {
                aloneElement = A.get(mid);
                return A.get(mid);
            }

            int firstOccurance = mid;
            if(A.get(mid).equals(A.get(mid-1))) {
                firstOccurance = mid - 1;
            }

            if(firstOccurance % 2 == 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return aloneElement;
    }
}

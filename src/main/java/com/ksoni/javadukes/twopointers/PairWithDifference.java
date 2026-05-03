package com.ksoni.javadukes.twopointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class PairWithDifference {
    public static void main(String[] args) {
        PairWithDifference pairWithDifference = new PairWithDifference();
        pairWithDifference.solve(new int[]{-5,-2,1,8,10,11,12,15}, 11);
    }

    public int solve(int[] A, int B) {
        Arrays.sort(A);

        int i = 0;
        int j = 1;
        long ans = 0;

        while (j<A.length) {
            if(j==i) {
                j++;
                continue;
            }

            int x = A[i];
            int y = A[j];
            if(y - x == B) {
                ans++;
                while (i < A.length && A[i] == x) {
                    i++;
                }
                while (j < A.length && A[j] == y) {
                    j++;
                }
            } else if(y - x > B) {
                i++;
            } else {
                j++;
            }

        }

        return (int) ans;


    }

}

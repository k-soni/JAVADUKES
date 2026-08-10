package com.ksoni.javadukes.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumPerfectSquare {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int[] dpList = new int[6+1];
        Arrays.fill(dpList, -1);

        MinimumPerfectSquare minimumPerfectSquare = new MinimumPerfectSquare();
        int ans = minimumPerfectSquare.solveFibWithDp(6,dpList);

        System.out.println(ans);

    }

    public int solveFibWithDp(int A, int[] dpList) {
        //top down
        if(A == 0) {
            dpList[0] = A;
            return A;
        }

        if(A == 1) {
            dpList[0] = 0;
            dpList[1] = 1;
            return A;
        }

        if(dpList[A] != -1) {
            return dpList[A];
        }

        int num = solveFibWithDp(A-1, dpList) + solveFibWithDp(A - 2, dpList);
        dpList[A] = num;
        return num;

    }


    public int solveFib(int A, List<Integer> list)  {
        // base case
        if(A <= 0) {
            return 0;
        }
        if (A == 1) {
            return 1;
        }

        //  what should function do
        int num = solveFib(A-2, list) + solveFib(A-1,list);
        // return
        return num;
    }


}

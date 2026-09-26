package com.ksoni.javadukes.Heaps;

public class DistributeCandy {
    public static void main(String[] args) {
        DistributeCandy distributeCandy = new DistributeCandy();
        int ans = distributeCandy.candy(new int[]{1, 5, 2, 1});
        System.out.println(ans);
    }

    public int candy(int[] A) {

        int[] ans = new int[A.length];
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            ans[i] = 1;
        }

        // left to right

        for (int i = 1; i < A.length; i++) {
            if(A[i] > A[i-1]) {
                ans[i] = ans[i-1] + 1;
            }
        }

        for (int i = A.length - 2; i >= 0 ; i--) {
            if(A[i] > A[i+1] && ans[i] <= ans[i+1]) {
                ans[i] = ans[i+1] + 1;
            }
        }


        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
            sum = sum + ans[i];
        }

        return sum;

    }
}

//Q1. Distribute Candy
//Unsolved
//feature icon
//Using hints except Complete Solution is Penalty free now
//Use Hint
//Problem Description
//
//N children are standing in a line. Each child is assigned a rating value.
//
//
//
//
//You are giving candies to these children subjected to the following requirements:
//
//
//Each child must have at least one candy.
//Children with a higher rating get more candies than their neighbors.
//
//What is the minimum number of candies you must give?
package com.ksoni.javadukes.SubArray;

public class MaxSumContiguousSubArray {
    public static void main(String[] args) {

    }

    public int findMaxSum(final int[] A) {
        int answer = 0;
        int current = Integer.MIN_VALUE;

        for (int num: A) {

            current += num;
            answer = Math.max(answer,current);
            current = Math.max(current,0);
        }
        return answer;
    }
}

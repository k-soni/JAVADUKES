package com.ksoni.javadukes.DP;

public class FibonacciNumber {

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        fibonacciNumber.solve(4);
    }

    public int solve(int A) {
        int[] dp = new int[A+1];
        for (int i = 0; i <= A; i++) {
            dp[i] = -1;
        }
        int result = solveFib(dp, A);

        return result;
    }

    public int solveFib(int[] dp, int A) {
        if(A == 0 || A == 1) {
            dp[A] = A;
            return A;
        }

        if(dp[A] != -1) {
            return dp[A];
        }

        int firstSeq = solveFib(dp, A-1);
        int secondSeq = solveFib(dp, A-2);

        dp[A] = firstSeq + secondSeq;

        return firstSeq + secondSeq;
    }


}

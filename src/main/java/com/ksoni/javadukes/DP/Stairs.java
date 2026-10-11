package com.ksoni.javadukes.DP;

public class Stairs {
    public static void main(String[] args) {
        Stairs stairs = new Stairs();
        int result = stairs.climbStairs(4);
        System.out.println(result);
    }

    int mod = 1000000007;
    public int climbStairs(int A) {

        int[] dp = new int[A+1];
        for(int i = 0; i<=A; i++) {
            dp[i] = -1;
        }

        int result = solve(dp, A);
        return result;

    }

    public int solve(int[] dp, int A) {
        if(A == 0 || A == 1) {
            dp[A] = 1;
            return 1;
        }

        if(dp[A] != -1) {
            return dp[A];
        }

        int wayOne = solve(dp, A-1);
        int wayTwo = solve(dp, A-2);
        dp[A] = (wayOne % mod + wayTwo % mod) % mod;
        return dp[A];
    }
}

//You are climbing a staircase and it takes A steps to reach the top.
//
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//Return the number of distinct ways modulo 1000000007
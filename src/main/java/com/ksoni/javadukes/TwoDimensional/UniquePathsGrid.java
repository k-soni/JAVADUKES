package com.ksoni.javadukes.TwoDimensional;

import java.util.ArrayList;

public class UniquePathsGrid {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();
        int[][] dp = new int[A.size()][A.get(0).size()];

        for (int i = 0; i < N; i++) {
            if(A.get(i).get(0) == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }

        }

        for (int j = 0; j < M; j++) {
            if(A.get(0).get(j) == 0) {
                dp[0][j] = 1;
            } else {
                break;
            }
        }

        for(int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if(A.get(i).get(j) == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[N-1][M-1];
    }
}

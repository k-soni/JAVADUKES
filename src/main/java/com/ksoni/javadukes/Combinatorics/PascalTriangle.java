package com.ksoni.javadukes.Combinatorics;

public class PascalTriangle {
    public static void main(String[] args) {

    }

    public int[][] solve(int A) {
        int[][] result = new int[A][A];

        for (int i = 0; i < A; i++) {
            for (int j = 0; j <= i ; j++) {

                if(j ==0 || j == i) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i-1][j-1] + result[i-1][j];
                }
            }
        }
        return result;
    }
}

package com.ksoni.javadukes.TwoDimensional;

import java.util.ArrayList;

public class SumOfSubMatrices {
    public static void main(String[] args) {

    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int ans = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.size(); j++) {
                int TL = (j + 1) * (i + 1);
                int BR = (A.size() - j) * (A.size() - i);
                ans = ans + A.get(i).get(j) * TL * BR;
            }
        }
        return ans;
    }
}

package com.ksoni.javadukes.medium.RainWater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RainWaterTrap {
    public static void main(final String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
        RainWaterTrap rainWaterBF = new RainWaterTrap();
        int result = rainWaterBF.solution(A);
    }

    public int solution(final List<Integer> A) {
        int trappedRainWater = 0;
        int[] leftMax = new int[A.size()];
        leftMax[0] = A.get(0);
        for (int j = 1; j < A.size(); j++) {
            leftMax[j] = Math.max(leftMax[j-1], A.get(j));
        }

        int[] rightMax = new int[A.size()];
        rightMax[A.size() - 1] = A.get(A.size() - 1);

        for (int z = A.size() - 2; z >= 0; z--) {
            rightMax[z] = Math.max(rightMax[z+1], A.get(z));
        }

        for (int i = 1; i < A.size()-1; i++) {
            int waterTrappedInCurrentBlock = Math.min(leftMax[i-1], rightMax[i+1]) - A.get(i);
            if(waterTrappedInCurrentBlock > 0) {
                trappedRainWater += waterTrappedInCurrentBlock;
            }
        }
        return trappedRainWater;
    }
}

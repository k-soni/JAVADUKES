package com.ksoni.javadukes.medium.RainWater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RainWaterTrap {
    public static void main(final String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(9,3,2,4,6,2,1,8));
        RainWaterTrap rainWaterBF = new RainWaterTrap();
        int result = rainWaterBF.solution(A);
        System.out.println("Trapped Water "+result);
    }

    public int solution(final List<Integer> A) {
        int trappedRainWater = 0;
        for (int i = 1; i < A.size()-1; i++) {
            int leftMax = -1;
            // get left side max bar
            for (int j = i-1; j >= 0 ; j--) {
                int currentElement = A.get(j);
                if(currentElement > leftMax) {
                    leftMax = currentElement;
                }
            }

            int rightMax = -1;
            for (int z = i+1; z < A.size(); z++) {
                int currentElement = A.get(z);
                if(currentElement > rightMax) {
                    rightMax = currentElement;
                }
            }

            int waterTrappedInCurrentBlock = Math.min(leftMax, rightMax) - A.get(i);
            if(waterTrappedInCurrentBlock > 0) {
                trappedRainWater += waterTrappedInCurrentBlock;
            }
        }
        return trappedRainWater;
    }
}

package com.ksoni.javadukes.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class PainterBS {

    public  static void main(final String[] args) {
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(185,186,938,558,655,461,441,234,902,681));
        int A = 3;
        int B = 10;

        PainterBS painterBS = new PainterBS();
        int ans = painterBS.getMinimumTime(A,B,C);
        System.out.println("ans  "+ ans);
    }

    /**
     * C[i] is the length of the board
     * A is numbers if the painter available
     * b is unit of time
     * */
    public int getMinimumTime(int A, int B, ArrayList<Integer> C) {
        // search space
        // min time to paint all the boards
        // max time to paint all the board
        int min = 0;
        int max = 0;
        int ans = 0;
        for (int num: C) {
            min = Math.max(num, min);
            max = max + num;
        }

        if(A == 1) {
            return (int)(((long)max*B)%10000003);
        }


        while (min <= max) {
            int mid = min + (max - min)/2;
            boolean isPossible = isPossible(mid, A,C);
            if(isPossible) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid+1;
            }

        }

        return (int)(((long)ans*B)%10000003);
    }


    public boolean isPossible(int target, int painters, ArrayList<Integer> allBoards) {
        int remainingUnits = target;
        int paintersOccupied = 1;
        for (Integer allBoard : allBoards) {
            int unitNeededForCurrentBoard = allBoard;
            if(unitNeededForCurrentBoard > target) {
                return false;
            }

            if (remainingUnits >= unitNeededForCurrentBoard) {
                remainingUnits = remainingUnits - unitNeededForCurrentBoard;
            } else {
                remainingUnits = target - unitNeededForCurrentBoard;
                paintersOccupied++;
            }
        }
        return painters >= paintersOccupied;
    }



}

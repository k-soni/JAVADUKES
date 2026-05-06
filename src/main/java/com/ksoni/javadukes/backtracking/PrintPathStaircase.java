package com.ksoni.javadukes.backtracking;

import java.util.ArrayList;

public class PrintPathStaircase {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> WaysToClimb(int A) {
        ArrayList<Integer> singleList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int idx = 0;

        solve(A,singleList, result, idx);
        return result;
    }

    public void solve(int A, ArrayList<Integer> singleList, ArrayList<ArrayList<Integer>> result, int idx ) {
        if(idx == A) {
            result.add(new ArrayList<>(singleList));
            return;
        }
        if(idx < A) {
            singleList.add(1);
            solve(A, singleList, result, idx+1);
            singleList.remove(singleList.size() -1);
        }

        if(idx < A-1) {
            singleList.add(2);
            solve(A, singleList, result, idx+2);
            singleList.remove(singleList.size() -1);
        }
    }

}

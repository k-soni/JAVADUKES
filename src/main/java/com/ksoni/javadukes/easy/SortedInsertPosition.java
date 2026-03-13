package com.ksoni.javadukes.easy;

import java.util.ArrayList;

public class SortedInsertPosition {
    public static void main(final String[] args){
        ArrayList<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(4);
        inputList.add(3);
        SortedInsertPosition solution = new SortedInsertPosition();
        solution.searchInsert(inputList, 3);
    }

    public int searchInsert(ArrayList<Integer> A, int B) {
        int res = A.size();
        int left = 0;
        int right = A.size() - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            int midElement = A.get(mid);
            if(midElement == B) {
                res = mid;
                return res;
            }
            if(midElement > B) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
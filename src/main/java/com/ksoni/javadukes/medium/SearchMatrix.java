package com.ksoni.javadukes.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchMatrix {
    public static void main(final String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        list.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
        list.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));
        list.add(new ArrayList<Integer>(Arrays.asList(7,8,9)));
        System.out.println("list "+ list.size());
        test solution = new test();
        int res = solution.searchMatrix(list, 5);
        System.out.println("ans "+ res);
    }

    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int ans = 0;

        for (int i = 0; i < A.size(); i++) {
            int left = 0;
            ArrayList<Integer> subList = A.get(i);
            int right = subList.size() - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int currentElement = subList.get(mid);
                if(currentElement == B) {
                    ans = 1;
                    return ans;
                }

                if(currentElement > B) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return ans;
    }


}

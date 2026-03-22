package com.ksoni.javadukes.easy;

import java.util.ArrayList;
import java.util.Arrays;


public class SingleElementInArray {
    public static void main(final String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(7,7,6,6,3,8,8,1,1,9,9));
        SingleElementInArray singleElementInArray = new SingleElementInArray();
        int ans = singleElementInArray.solve(A);
        System.out.println(ans);
    }


    public int solve(ArrayList<Integer> A) {
        int left = 0;
        int right = A.size() - 1;
        int ans = -1;

        while(left <= right) {
            int mid = left + (right - left)/2;
            if(A.get(mid-1) != A.get(mid)+1) {
                ans = mid;
                return ans;
            }

//            int firstOccurance = mid;
//            if(A.get(firstOccurance) == A.get(firstOccurance -1)) {
//
//            }
            if(mid%2 == 0 && A.get(mid-1).equals(A.get(mid))) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return  ans;
    }
}

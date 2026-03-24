package com.ksoni.javadukes.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatedSortedArray {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(4,5,6,7,0,1,2,3));

        RotatedSortedArray rotatedSortedArray = new RotatedSortedArray();
        int res = rotatedSortedArray.search(input, 2);
        System.out.println(res);
    }

    public int search(final List<Integer> A, int B) {
        int left = 0;
        int right = A.size() - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if(A.get(mid) == B) {
                ans = mid;
                return ans;
            }

            if(A.get(mid) >= A.get(0) && B < A.get(0)) {
                left = mid + 1;
            } else if(A.get(mid) < A.get(0) && B >= A.get(0)) {
                right = mid - 1;
            } else {
                if(A.get(mid) < B) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return  ans;
    }

}

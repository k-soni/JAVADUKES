package com.ksoni.javadukes.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfTwoArrays {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5,6));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(7));

        MedianOfTwoArrays medianOfTwoArrays = new MedianOfTwoArrays();
        medianOfTwoArrays.solution(A,B);
    }

    public int solution(ArrayList<Integer> A, ArrayList<Integer> B) {

        if(A.size() > B.size()) {
            ArrayList<Integer> temp = A;
            A = B;
            B = temp;
        }

        int N = A.size();
        int M = B.size();
        int X = (N+M)/2;
        int total = N+M;

        int left = 0;
        int right = Math.min(X, N);

        while (left <= right) {
            int mid = left + (right - left)/2;
            int rem = X - mid;

            int L1 = mid - 1 >= 0 ? A.get(mid - 1) : Integer.MIN_VALUE;
            int R1 = mid < N ? A.get(mid) : Integer.MAX_VALUE;
            int L2 = rem - 1 >= 0 ? B.get(rem - 1) : Integer.MIN_VALUE;
            int R2 = rem < M ? B.get(rem) : Integer.MAX_VALUE;

            if(L1 <= R2 && L2 <= R1) {
                if(total % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                } else {
                    return Math.min(R1, R2);
                }

            } else if(L1 > R2) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return  -1;


    }

}


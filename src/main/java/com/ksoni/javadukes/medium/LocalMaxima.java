package com.ksoni.javadukes.medium;

import java.util.ArrayList;

public class LocalMaxima {
    public static void main(final String[] args) {
        LocalMaxima solution = new LocalMaxima();
        solution.localMaxima(null)
    }

    public int localMaxima(ArrayList<Integer> A) {
        int ans = 0;
        int left = 0;
        int right = A.size()-1;

        if(A.size() == 1) {
            ans = A.get(0);
            return ans;
        }

        if(A.get(left) >= A.get(left + 1)){
            ans = A.get(0);
            return ans;
        }

        if(A.get(right) >= A.get(right-1)){
            ans = A.get(right);
            return ans;
        }

        left = 1;
        right = right - 1;

        while(left<= right) {
            int mid = left + (right - left)/2;
            int currentElement = A.get(mid);
            int previousElement = A.get(mid -1);
            int nextElement = A.get(mid + 1);

            // local minima
            if(currentElement > previousElement && currentElement > nextElement) {
                ans = currentElement;
                return ans;
            }

            if(currentElement > previousElement && currentElement < nextElement) {
                left = mid + 1;
            } else if(previousElement > currentElement   && currentElement > nextElement) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }


        }
        return ans;
    }
}

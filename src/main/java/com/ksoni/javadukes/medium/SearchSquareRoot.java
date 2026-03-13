package com.ksoni.javadukes.medium;

public class SearchSquareRoot {
    public static void main(final String[] args) {
       SearchSquareRoot solution  = new SearchSquareRoot();
        int ans = solution.sqrt(2147483647);
        System.out.print(ans);
    }

    public int sqrt(int A) {
        int start = 1;
        int end = A;
        int ans = 0;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if((long)mid*mid <= A) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println("anser");
        System.out.println(ans);
        return ans;
    }
}

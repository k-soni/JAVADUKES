package com.ksoni.javadukes.PrimeNumbers;

import java.util.ArrayList;

public class CountOfDivisorOptimized {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int maxEle = 0;
        for (int num: A) {
            maxEle = Math.max(num,maxEle);
        }

        int[] divisors = new int[maxEle+1];

        for (int i = 1; i <= maxEle ; i++) {
            for (int j = i; j <= maxEle ; j+=i) {
                divisors[j] += 1;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < A.size() ; i++) {
            ans.add(divisors[A.get(i)]);
        }

        return ans;
    }


}

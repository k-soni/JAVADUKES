package com.ksoni.javadukes.PrimeNumbers;

import java.util.ArrayList;
import java.util.Arrays;

public class FindAllPrimeNumbersOptimized {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(int A) {
        boolean[] isPrimeNumber = new boolean[A+1];
        ArrayList<Integer> ans = new ArrayList<>();

        Arrays.fill(isPrimeNumber, true);

        if(A >= 0) {
            isPrimeNumber[0] = false;
        }

        if(A>=1) {
            isPrimeNumber[1] = false;
        }

        for (int i = 2; i*i <= A ; i++) {
            if(isPrimeNumber[i]) {
                for (int j =  i*i; j <= A ; j = j+i) {
                    isPrimeNumber[j] = false;
                }
            }
        }

        for (int i = 0; i < isPrimeNumber.length; i++) {
            if(isPrimeNumber[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

}

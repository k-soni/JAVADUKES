package com.ksoni.javadukes.PrimeNumbers;

import java.util.ArrayList;

public class CountOfDivisorsFinal {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int maxEle = 0;
        for (int num:A) {
            maxEle = Math.max(num, maxEle);
        }
        int[] spf = setSpf(maxEle);
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            int factors = countDivisor(A.get(i), spf);
            res.add(factors);
        }

        return res;

    }



    public int[] setSpf(int maxEle) {

        int[] spf = new int[maxEle+1];
        for (int i = 0; i < spf.length; i++) {
            spf[i] = i;
        }

        for (int i = 2; i*i <= maxEle ; i++) {
            if(spf[i] == i) {
                for (int j = i*i; j <= maxEle ; j+=i) {
                    if(spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        return spf;
    }

    public int countDivisor(int n, int[] spf) {
        if(n == 1) {
            return n;
        }
        int divisors = 1;

        while (n > 1) {
            int p = spf[n];
            int count = 0;
            while (n%p == 0) {
                count++;
                n /= p;
            }

            divisors *= count+1;
        }
        return  divisors;

    }


}


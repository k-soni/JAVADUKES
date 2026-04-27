package com.ksoni.javadukes.PrimeNumbers;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeNumbersSeive {
    public static void main(String[] args) {
        PrimeNumbersSeive primeNumbersSeive = new PrimeNumbersSeive();
        primeNumbersSeive.solve(10);
    }

    public int[] solve(int A) {
        boolean[] result = new boolean[A+1];
        int count = 0;
        Arrays.fill(result, true);

        if(A >= 0) {
            result[0] = false;
        }
        if(A >= 1) {
            result[1] = false;
        }

        for (int i = 2; i * i <= A ; i++) {
            if(result[i]) {
                count = count+1;
                // harmonic progression
                // 1/2 + 1/3 + 1/5 + 1/7....
                // log logN
                for (int j = i*i; j <= A ; j=j+i) {
                    result[j] = false;
                }
            }
        }


        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            if(result[i]){
                temp.add(i);
            }
        }

        int[] output = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            output[i] = temp.get(i);
        }

        return output;
    }

}


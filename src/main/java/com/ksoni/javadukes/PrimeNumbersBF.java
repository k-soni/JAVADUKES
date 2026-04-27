package com.ksoni.javadukes;

import java.util.Arrays;

public class PrimeNumbersBF {
    public static void main(String[] args) {
        PrimeNumbersBF primeNumbersBF = new PrimeNumbersBF();
        primeNumbersBF.solve(14);
    }

    public int[] solve(int A) {
        int[] output = new int[A+1];

        output[0] = 0;
        output[1] = 0;

        for (int i = 1; i <=A ; i++) {
            int factors = countFactors(i);
            if(factors == 2) {
                output[i] = i;
            }
        }
        return Arrays.stream(output).filter(num -> num != 0).toArray();
    }


    public int countFactors(int A) {
        if(A <= 0) {
            return 0;
        }

        if(A == 1) {
            return 1;
        }

        int count = 0;

        for (int i = 1; i * i <=A ; i++) {
            if(A%i == 0) {
               if(i*i == A) {
                   count++;
               } else {
                   count = count + 2;
               }
            }
        }
        return count;
    }


}

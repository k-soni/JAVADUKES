package com.ksoni.javadukes.PrimeNumbers;

public class CountOfDivisor {
    public static void main(String[] args) {

    }

    public int[] solve(int[] A) {
        int maxVal = 0;

        for (int x:A) {
            maxVal = Math.max(maxVal, x);
        }

        int[] countDivisors = new int[maxVal +1];

        for (int i = 1; i <=maxVal; i++) {
            for (int j = i; j <= maxVal; j = j+i) {
                countDivisors[j] += 1;
            }
        }

        int[] result = new int[A.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = countDivisors[A[i]];
        }

        return result;

    }

    public int countDivisorfs(int num) {
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if(num%i == 0) {
                if(i * i <= num) {
                    count = count+2;
                } else {
                    count++;
                }
            }
        }
        return count;
    }
 }

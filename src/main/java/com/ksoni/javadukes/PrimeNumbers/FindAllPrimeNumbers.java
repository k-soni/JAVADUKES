package com.ksoni.javadukes.PrimeNumbers;

import java.util.ArrayList;

public class FindAllPrimeNumbers {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(int A) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 2; i <= A; i++) {
            int count = countFactor(i);
            if(count == 2) {
                result.add(i);
            }
        }
        return result;
    }


    public int countFactor(int A) {
        int count = 0;

        for (int i = 1; i*i<=A; i++) {
            if(A%i == 0) {
                if(i*i == A) {
                    count = count + 1;
                } else {
                    count = count + 2;
                }
            }
        }

        return count;
    }


}

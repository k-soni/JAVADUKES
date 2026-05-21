package com.ksoni.javadukes.PrimeNumbers;

import java.util.ArrayList;

public class CountOfDivisorsV1 {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < A.size() ; i++) {
            int count = countFactor(A.get(i));
            result.add(count);
        }
        return result;
    }

    public int countFactor(int A) {
        int count = 0;
        for (int i = 1; i*i <= A ; i++) {
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

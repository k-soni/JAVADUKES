package com.ksoni.javadukes.Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class CountPair {
    public static void main(String[] args) {
        CountPair countPair = new CountPair();
        countPair.solve(new int[]{3,5,1,2,1,2}, 3);
    }

    public int solve(int[] A, int K) {
        HashMap<Integer,Integer> hashSet = new HashMap<>();

        int count = 0;

        for (int i = 0; i < A.length; i++) {
            int currentElement = A[i];
            int diff = K - currentElement;
            if(hashSet.containsKey(diff)) {
               count = count + hashSet.get(diff);
            }
            if(hashSet.containsKey(currentElement)) {
                hashSet.put(currentElement, hashSet.get(diff) + 1);
            } else {
                hashSet.put(currentElement, 1);
            }
        }
        System.out.println(count);
        return count;
    }
}

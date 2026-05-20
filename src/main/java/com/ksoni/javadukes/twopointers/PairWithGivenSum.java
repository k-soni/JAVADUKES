package com.ksoni.javadukes.twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PairWithGivenSum {
    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;
        for (int k = 0; k < A.size(); k++) {
            int diff = B - A.get(k);
            if(hashMap.containsKey(diff)) {
                int val = hashMap.get(diff);
                count = count + val;
            }

            hashMap.put(A.get(k), hashMap.getOrDefault(A.get(k), 1));
        }
        return count;

    }
}

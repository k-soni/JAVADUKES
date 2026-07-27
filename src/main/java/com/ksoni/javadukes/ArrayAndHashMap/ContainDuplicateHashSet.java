package com.ksoni.javadukes.ArrayAndHashMap;

import java.util.HashSet;
import java.util.Set;

public class ContainDuplicateHashSet {

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        boolean result = containsDuplicate.solve(new int[]{3,4,3,6,7,8,1});
        System.out.println(result);

    }

    public boolean solve(int[] A) {
        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if(hashSet.contains(A[i])){
                return true;
            } else {
                hashSet.add(A[i]);
            }

        }

        return false;
    }
}

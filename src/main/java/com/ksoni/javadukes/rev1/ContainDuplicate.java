package com.ksoni.javadukes.rev1;

import java.util.HashSet;
import java.util.Set;

//Problem Statement
//
//Given an integer array, determine whether any value appears at least twice.
//
//Return true if any duplicate exists, otherwise return false.
public class ContainDuplicate {
    public static void main(String[] args) {
        ContainDuplicate containDuplicate = new ContainDuplicate();
        boolean isDuplicate = containDuplicate.solve(new int[]{1,2,3,4,5,6});
        System.out.println(isDuplicate);
    }

    public boolean solve(int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (set.contains(A[i])) {
                return true;
            }
            set.add(A[i]);
        }
        return false;
    }
}

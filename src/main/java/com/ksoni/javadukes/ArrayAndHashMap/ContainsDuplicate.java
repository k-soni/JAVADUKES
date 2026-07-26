package com.ksoni.javadukes.ArrayAndHashMap;

public class ContainsDuplicate {
    public static void main(String[] args) {

        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        boolean result = containsDuplicate.solve(new int[]{3,2,3,4,5,6,1});
        System.out.println(result);
    }

    public boolean solve(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1 ; j < A.length; j++) {
                if(i == j){
                    continue;
                }
                if(A[i] == A[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}

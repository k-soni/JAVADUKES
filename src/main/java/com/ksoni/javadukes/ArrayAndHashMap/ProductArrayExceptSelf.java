package com.ksoni.javadukes.ArrayAndHashMap;

public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        ProductArrayExceptSelf productArrayExceptSelf = new ProductArrayExceptSelf();
        int[] res = productArrayExceptSelf.solveOptimized(new int[]{1,2,3,4});

        for (int num: res) {
            System.out.println(num);
        }

    }

    int[] solveBF(int[] A) {
        int[] ans = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            int temp = 1;
            for (int j = 0; j < A.length; j++) {
                if(i == j) {
                    continue;
                }
                temp *= A[j];
            }
            ans[i] = temp;
        }
        return ans;
    }

    int[] solveOptimized(int[] A) {
        int[] result = new int[A.length];
        // Product of left items
        result[0] = 1;

        for (int i = 1; i < A.length; i++) {
            result[i] = result[i-1] * A[i-1];
        }

        // Product of right to left

        int suffix = 1;

        for (int i = A.length -1; i >= 0; i--) {
            result[i] = result[i] * suffix;
            suffix = suffix * A[i];
        }

        return  result;
    }
}

package com.ksoni.javadukes.rev1;

import com.ksoni.javadukes.ArrayAndHashMap.ProductArrayExceptSelf;

/*Problem Statement

Given an integer array nums, return an array answer such that

answer[i]

is equal to the product of all elements of nums except nums[i].

Do not use division.

The solution must run in O(n).*/
public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        ProductofArrayExceptSelf  productArrayExceptSelf = new ProductofArrayExceptSelf();
        int[] result = productArrayExceptSelf.solve(new int[]{1,2,3,4});

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] solve(int[] A) {
        int[] result = new int[A.length];
        result[0] = 1;
        // left product
        // [1,1,2,6]
        for (int i = 1; i < A.length; i++) {
            result[i] =  result[i-1]*A[i-1];
        }

        //right product
        // [ 24,12,8,6]
        int suffix = 1;
        for (int i = A.length - 1; i>=0; i--) {
            result[i] = result[i]*suffix;
            suffix = suffix*A[i];
        }

        return result;
    }
}

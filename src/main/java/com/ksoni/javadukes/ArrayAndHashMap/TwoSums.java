package com.ksoni.javadukes.ArrayAndHashMap;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {

    public static void main(String[] args) {
        TwoSums twoSums = new TwoSums();
        int[] res = twoSums.solveOptimisedApproach1(new int[]{2,4,5,6,7,3}, 5);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public int[] solveBruteForce(int[] A, int target) {
        int[] ans = new int[2];

        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                if (A[i]+A[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return ans;
    }


    public int[] solveOptimisedApproach1(int[] A, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < A.length; i++) {
            int diff = target - A[i];

            if(map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(A[i], i);

        }

        return ans;
    }





}

/*
* 1. Two Sum
  Problem Statement

 Given an array of integers nums and an integer target,
 return the indices of the two numbers such that they add up to target.

  You may assume that each input has exactly one solution,
  and you may not use the same element twice.

  Function Signature
        int[] twoSum(int[] nums, int target)
    Constraints
        2 <= nums.length <= 10^5

        -10^9 <= nums[i] <= 10^9

        -10^9 <= target <= 10^9

    Exactly one valid answer exists.
     Sample Input
        nums = [2,7,11,15]
        target = 9
     Sample Output
        [0,1]
 */



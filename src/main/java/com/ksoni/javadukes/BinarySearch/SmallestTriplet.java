package com.ksoni.javadukes.BinarySearch;

import java.util.Arrays;

public class SmallestTriplet {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5};
        SmallestTriplet smallestTriplet = new SmallestTriplet();
        int res = smallestTriplet.solution(nums, 3);
        System.out.println(res);
        int test = smallestTriplet.possibleTriplets(nums, nums.length, 11);
        System.out.println(test);
    }

    public int solution(int[] nums, int B) {
        Arrays.sort(nums);
        int ans = 0;
        int N = nums.length;
        // search space
        int smallestTriplet = nums[0]+nums[1]+nums[2];
        int greatestTriplet = nums[N-3]+nums[N-2]+nums[N-1];

        while (smallestTriplet <= greatestTriplet) {
            int midTriplet = smallestTriplet + (greatestTriplet-smallestTriplet)/2;
            int minimumTriplet = possibleTriplets(nums, N,midTriplet);
            if(minimumTriplet < B) {
               ans = midTriplet;
               smallestTriplet = midTriplet + 1;
            } else {
                greatestTriplet = midTriplet - 1;
            }
        }
        return ans;
    }

    public int possibleTriplets(int[] nums,int N, int mid) {

       int count = 0;

        for (int i = 0; i < N-2 ; i++) {
            int j = i+1;
            int k = N-1;

            while (j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum < mid) {
                    count += k-j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return  count;
    }
}


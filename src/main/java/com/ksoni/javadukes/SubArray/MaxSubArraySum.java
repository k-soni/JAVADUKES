package com.ksoni.javadukes.SubArray;

public class MaxSubArraySum {
    public static void main(String[] args) {
        MaxSubArraySum maxSubArraySum = new MaxSubArraySum();
        System.out.println(maxSubArraySum.calculateMaxSubArraySumKadane(new int[]{10, -2, 3, 40, 5}, 5));
    }

    public void calculateMaxSubArraySumBruteForce() {

    }

    public int calculateMaxSubArraySumPrefixSum(int[] arr, int len) {
        int ans = Integer.MIN_VALUE;
        int tempsum = 0;
        for (int i = 0; i < len; i++) {

            tempsum += arr[i];

            ans = Math.max(ans, tempsum);

            tempsum = Math.max(0, tempsum);

        }
        return ans;
    }

    public int calculateMaxSubArrayCarryForward(int[] arr, int len) {
        int totalSum = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            int tempSum = 0;
            for (int j = i; j < len; j++) {
                tempSum = tempSum + arr[j];
                if(totalSum < tempSum) {
                    totalSum = tempSum;
                }
            }
        }

        return totalSum;
    }

    public int calculateMaxSubArraySumKadane(int[] arr, int len) {
        int totalSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < len; i++) {
            int currentElement = arr[i];
            currentSum = currentSum + currentElement;

            totalSum = Math.max(totalSum, currentSum);

            currentSum = Math.max(0, currentSum);

        }
        return totalSum;
    }


}

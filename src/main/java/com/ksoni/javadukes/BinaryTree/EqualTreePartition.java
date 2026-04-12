package com.ksoni.javadukes.BinaryTree;

import com.ksoni.javadukes.common.TreeNode;

public class EqualTreePartition {
    public static void main(String[] args) {

    }
    int isEqualPartition = 0;


    public int solve(TreeNode A) {

        long totalNodeValue = findOverAllsum(A);
        if(totalNodeValue%2 == 1) {
            return 0;
        } else {
            findOverAllsum2(A, totalNodeValue/2);
        }

        return  isEqualPartition;
    }

    public long findOverAllsum(TreeNode A) {
        if(A == null) {
            return 0;
        }
        long leftSum = findOverAllsum(A.left);
        long rightSum = findOverAllsum(A.right);
        return A.val + leftSum + rightSum;
    }

    public long findOverAllsum2(TreeNode A, long target) {

        if(A == null) {
            return 0;
        }
        long leftSum = findOverAllsum2(A.left, target);
        long rightSum = findOverAllsum2(A.right, target);
        long totalSum = leftSum + rightSum + A.val;
        if(totalSum == target) {
            isEqualPartition = 1;
        }
            return totalSum;

    }
}

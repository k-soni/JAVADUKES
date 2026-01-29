package com.ksoni.javadukes.medium;

import com.ksoni.javadukes.common.TreeNode;

public class SumBinaryTree {
    public static void main(final String[] args) {
        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(5);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(5);

        SumBinaryTree solution = new SumBinaryTree();
        solution.sumBinaryTree(root);
    }

    public int sumBinaryTree(TreeNode A) {
        if (A == null) {
            return 0;
        }

        int sumOfLST = getSumofNodes(A.left);
        int sumOfRST = getSumofNodes(A.right);
        if(A.val == sumOfLST + sumOfRST) {
            return 1;
        }
        return 0;
    }

    private int getSumofNodes(TreeNode A) {
        if (A == null) {
            return 0;
        }
        return getSumofNodes(A.left) + getSumofNodes(A.right) + A.val;
    }
}

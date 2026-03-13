package com.ksoni.javadukes.medium;

import com.ksoni.javadukes.common.TreeNode;

public class DeserializeBinaryTree {
    public static void main(final String[] args) {

    }

    public void deserializeBinaryTree(int[] A) {
        TreeNode root = new TreeNode(A[0]);

        for (int i = 1; i < A.length; i++) {
           TreeNode currentNode = root;

            while (currentNode.left != null) {
                currentNode = currentNode.left;
            }

            if(currentNode.left == null && A[i] != -1) {
                root.left = new TreeNode(A[i]);
                continue;
            }

             while (currentNode.right != null) {
                currentNode = currentNode.right;
            }

            if(currentNode.right == null && A[i] != -1) {
                root.right = new TreeNode(A[i]);
                continue;
            }

        }
    }
}

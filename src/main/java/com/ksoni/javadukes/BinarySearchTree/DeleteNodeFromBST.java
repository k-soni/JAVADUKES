package com.ksoni.javadukes.BinarySearchTree;

import com.ksoni.javadukes.common.TreeNode;

public class DeleteNodeFromBST {
    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode A, int K) {
        if(A == null) {
            return null;
        }
        if(A.val == K) {
            if(A.left == null && A.right == null) {
                return null;
            } else if (A.left != null && A.right == null) {
                return A.left;
            } else if (A.left == null && A.right != null) {
                return A.right;
            } else {
                TreeNode temp = A.left;
                while (temp.right !=null) {
                    temp = temp.right;
                }
                swap(temp,A);
                A.left = deleteNode(A.left, K);
                return A;
            }
        } else if (K < A.val) {
            A.left = deleteNode(A.left, K);
        } else {
            A.right = deleteNode(A.right, K);
        }
        return A;
    }

    public void swap(TreeNode temp, TreeNode root) {
        int tempVal = root.val;
        root.val = temp.val;
        temp.val = tempVal;
    }


}

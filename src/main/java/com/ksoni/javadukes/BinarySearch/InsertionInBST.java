package com.ksoni.javadukes.BinarySearch;

import com.ksoni.javadukes.common.TreeNode;

public class InsertionInBST {
    public static void main(String[] args) {

    }

    public TreeNode insert(TreeNode A, int K) {

        if(A ==null) {
            return new TreeNode(K);
        }

        if(A.val == K) {
            return A;
        }

        if(K < A.val) {
           A.left = insert(A.left, K);
        } else {
            A.right = insert(A.right, K);
        }

        return A;
    }
}

package com.ksoni.javadukes.BinaryTree;

import com.ksoni.javadukes.common.TreeNode;

public class SearchBST {
    public static void main(String[] args) {

    }

    public int solve(TreeNode A, int B) {
        if(A == null) {
            return 0;
        }
        if(A.val == B) {
            return 1;
        }
        if(B > A.val ) {
           return solve(A.right, B);
        } else {
            return solve(A.left, B);
        }

     }
}

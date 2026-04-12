package com.ksoni.javadukes.BinaryTree;

import com.ksoni.javadukes.common.TreeNode;

public class PathSum {

    public static void main(String[] args) {

    }

    public int hasPathSum(TreeNode A, int B) {
        boolean validPath =  solve(A, B);
        if(validPath) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean solve(TreeNode A, int B) {
        if(A == null) {
            return false;
        }
        if(A.left == null && A.right == null && A.val == B) {
            return true;
        }
        int target = B - A.val;
        boolean lans = solve(A.left, target);
        boolean rans = solve(A.right, target);

        return lans || rans;
    }



}

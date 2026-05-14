package com.ksoni.javadukes.BinaryTree;

import com.ksoni.javadukes.common.TreeNode;

public class LeastCommonAncestor {

    public static void main(String[] args) {

    }

    public TreeNode lcaNode(TreeNode A, int B, int C) {
        if(A == null) {
            return null;
        }

        if(A.val == B || A.val == C) {
            return A;
        }

        TreeNode left = lcaNode(A.left,B,C);
        TreeNode right = lcaNode(A.right,B,C);

        if(left != null && right != null) {
            return A;
        }

        return left == null ? right : left;
    }

    public boolean nodeExists(TreeNode A, int B) {
        if(A == null) {
            return false;
        }

        if(A.val == B ) {
            return true;
        }

        return nodeExists(A.left, B) || nodeExists(A.right, B);
    }


    public int lca(TreeNode A, int B, int C) {
        if(A == null) {
            return -1;
        }

        if(!nodeExists(A,B) || !nodeExists(A,C)) {
            return -1;
        }

        TreeNode node = lcaNode(A, B, C);

        return node == null ? -1 : node.val;
    }


}

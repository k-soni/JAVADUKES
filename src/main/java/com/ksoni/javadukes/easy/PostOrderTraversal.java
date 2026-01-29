package com.ksoni.javadukes.easy;

import java.util.ArrayList;

import com.ksoni.javadukes.common.TreeNode;

public class PostOrderTraversal {
    public static void main(final String[] args) {

    }

    public int[] postOrderTraversal(TreeNode A) {
        if(A == null) {
            return new int[0];
        }
        ArrayList<Integer> vals = new ArrayList<Integer>();
        traversalHelper(A, vals);
        int[] output = new int[vals.size()];
        for (int i = 0; i < vals.size(); i++) {
            output[i] = vals.get(i);
        }

        return output;

    }

    private void traversalHelper(TreeNode A, ArrayList<Integer> vals) {
        if(A == null) {
            return;
        }
        traversalHelper(A.left, vals);
        traversalHelper(A.right, vals);
        vals.add(A.val);
    }
}

package com.ksoni.javadukes.BinarySearchTree;

import com.ksoni.javadukes.common.TreeNode;

public class KthSmallestNumber {
    int count = 0;
    int ans = Integer.MIN_VALUE;
    public static void main(String[] args) {

    }

    public int kthsmallest(TreeNode A, int B) {

        solve(A,B);
        return ans;


    }

    public void solve(TreeNode A, int B) {
        if(A == null) {
            return;
        }
        if(ans == Integer.MIN_VALUE) {
            kthsmallest(A.left, B);
        }

        count++;
        if(count == B) {
           ans = A.val;
        }
        if(ans == Integer.MIN_VALUE) {
            kthsmallest(A.right,B);
        }

    }




}

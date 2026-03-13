package com.ksoni.javadukes.medium;

import com.ksoni.javadukes.common.TreeNode;

public class SearchBinaryTree {
    public static void main(final String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(19);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(5);


        SearchBinaryTree solution = new SearchBinaryTree();
        solution.searchBT(root, 10);
    }

    public int searchBT(TreeNode A, int K) {
        TreeNode currentNode = A;
        int ans = 0;
        while (currentNode != null) {
            if(currentNode.val == K) {
                ans = 1;
                return 1;
            } else if (currentNode.left.val > K) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return ans;
    }
}

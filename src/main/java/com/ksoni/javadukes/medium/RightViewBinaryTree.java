package com.ksoni.javadukes.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;

import com.ksoni.javadukes.common.TreeNode;

public class RightViewBinaryTree {
    public static void main(final String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

       RightViewBinaryTree solution = new RightViewBinaryTree();
       solution.rightViewBinaryTree(root);
    }

    public int[] rightViewBinaryTree(TreeNode A) {
        ArrayDeque<TreeNode> treeQueue = new ArrayDeque<TreeNode>();
        ArrayList<Integer> rightViewNums = new ArrayList<Integer>();

        treeQueue.add(A);
        while (!treeQueue.isEmpty()) {
            int size = treeQueue.size();

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = treeQueue.peek();
                treeQueue.pop();
                if(i == size - 1) {
                    rightViewNums.add(currentNode.val);
                }

            if(currentNode.left != null) {
                treeQueue.add(currentNode.left);
            }

            if(currentNode.right != null) {
                treeQueue.add(currentNode.right);
            }
            }


        }

        int[] ans = new int[rightViewNums.size()];
        for (int i = 0; i < rightViewNums.size(); i++) {;
            ans[i] = rightViewNums.get(i);
        }
        return ans;
    }
}

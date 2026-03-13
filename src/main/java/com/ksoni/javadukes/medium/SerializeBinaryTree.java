package com.ksoni.javadukes.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;

import com.ksoni.javadukes.common.TreeNode;

public class SerializeBinaryTree {
    public static void main(final String[] args) {
        TreeNode root = new TreeNode(-1);
        SerializeBinaryTree solution = new SerializeBinaryTree();
        solution.levelOrderTraversal(root);
    }

    public int[] levelOrderTraversal(TreeNode A) {
        ArrayDeque<TreeNode> deQueue = new ArrayDeque<TreeNode>();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        deQueue.add(A);

        while (!deQueue.isEmpty()) {
            int size = deQueue.size();

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = deQueue.peek();
                deQueue.poll();
                nums.add(currentNode.val);

                if(currentNode.left != null) {
                    deQueue.add(currentNode.left);
                }

                if(currentNode.right != null) {
                    deQueue.add(currentNode.right);
                }

                if(currentNode.left == null) {
                    nums.add(-1);
                }
                if(currentNode.right == null) {
                    nums.add(-1);
                }
            }
        }

        int[] output = new int[nums.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = nums.get(i);
        }
        return output;

    }
}

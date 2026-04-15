package com.ksoni.javadukes.BinaryTree;

import com.ksoni.javadukes.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderBinaryTree {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode ele = queue.poll();
                level.add(ele.val);

                if(ele.left != null) {
                    queue.add(ele.left);
                }
                if(ele.right != null) {
                    queue.add(ele.right);
                }
            }
            matrix.add(level);
        }

        return matrix;
    }
}

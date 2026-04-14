package com.ksoni.javadukes.BinaryTree;

import com.ksoni.javadukes.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class RightViewBinaryTree {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(TreeNode A) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> level = new ArrayList<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            int size = queue.size();


            for (int i = 0; i < size; i++) {
                TreeNode ele = queue.poll();
                if( i == size -1) {
                    level.add(ele.val);
                }

                if(ele.left != null) {
                    queue.add(ele.left);
                }
                if(ele.right != null) {
                    queue.add(ele.right);
                }
            }

        }

        return matrix;
    }


}

package com.ksoni.javadukes.BinaryTree;

import com.ksoni.javadukes.common.TreeNode;

import java.util.ArrayList;

public class BTFromIOrderPost {
    public static void main(String[] args) {

    }


    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        return constructTree(A,B,0, A.size() -1 , 0, B.size() -1);
    }

    public TreeNode constructTree(ArrayList<Integer> A, ArrayList<Integer> B, int inSIdx, int inEIdx, int pSIdx, int pEIdx) {
        if(inSIdx > inEIdx) {
            return null;
        }

        if(inSIdx == inEIdx) {
            return new TreeNode(B.get(pEIdx));
        }

        TreeNode node = new TreeNode(B.get(pEIdx));

        int rootNodeIndex = -1 ;

        for (int i = inSIdx; i <= inEIdx; i++) {
            if(A.get(i) == node.val) {
                rootNodeIndex = i;
                break;
            }
        }

        int count = rootNodeIndex - inSIdx;
        node.left = constructTree(A, B, inSIdx, rootNodeIndex - 1, pSIdx, pSIdx+count - 1 );
        node.right = constructTree(A, B, rootNodeIndex+1, inEIdx, pSIdx+count, pEIdx -1 );
        return node;
    }


}

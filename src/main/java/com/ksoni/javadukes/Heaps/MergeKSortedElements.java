package com.ksoni.javadukes.Heaps;

import com.ksoni.javadukes.common.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedElements {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ArrayList<ListNode> A) {

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                Comparator.comparingInt(node -> node.val)
        );


        ListNode listNodeFinal = null;
        ListNode temp = null;

        for (int i = 0; i < A.size(); i++) {
            ListNode listNode = A.get(i);
            priorityQueue.offer(listNode);
        }


        while (!priorityQueue.isEmpty()){
            ListNode listNode = priorityQueue.poll();
            if(listNode.next != null) {
                priorityQueue.offer(listNode.next);
            }
            if( listNodeFinal == null) {
                listNodeFinal = listNode;
                temp = listNode;
            } else {
                temp.next = listNode;
                temp = temp.next;
            }

        }
        return listNodeFinal;


    }

}

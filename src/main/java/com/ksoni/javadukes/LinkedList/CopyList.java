package com.ksoni.javadukes.LinkedList;

import com.ksoni.javadukes.common.RandomListNode;

public class CopyList {

    public static void main(String[] args) {

        // Create nodes
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);

        // Set next pointers (1 -> 2 -> 3 -> 4)
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Set random pointers
        node1.random = node3; // 1 -> 3
        node2.random = node1; // 2 -> 1
        node4.random = null;  // 4 -> null

        // Print list
        printList(node1);

        CopyList list = new CopyList();
        list.copyRandomList(node1);
    }

    public static void printList(RandomListNode head) {
        RandomListNode curr = head;
        while (curr != null) {
            int randomLabel = (curr.random != null) ? curr.random.label : -1;
            System.out.println("Node: " + curr.label +
                    ", Next: " + (curr.next != null ? curr.next.label : "null") +
                    ", Random: " + (randomLabel != -1 ? randomLabel : "null"));
            curr = curr.next;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode temp = head;

        while (temp != null) {
            RandomListNode newNode = new RandomListNode(temp.label);

            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        temp = head;

        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        RandomListNode clonedNode = head.next;
        temp = head;
        RandomListNode clonedTemp = clonedNode;

        while (temp != null) {

            RandomListNode copy = temp.next;
            temp.next = copy.next;

            if(copy.next != null) {
                copy.next = copy.next.next;
            }
            temp = temp.next;
        }

        return clonedNode;

    }

}


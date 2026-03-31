package com.ksoni.javadukes.LinkedList;

import com.ksoni.javadukes.common.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode A) {
        ListNode nextNode = A;
        ListNode prevNode = null;
        ListNode currentNode = A;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        A = prevNode;

        return  A;
    }
}

package com.ksoni.javadukes.LinkedList;

import com.ksoni.javadukes.common.ListNode;

public class MiddleofLinkedList {
    public static void main(String[] args) {

    }

    public static ListNode getMiddleNode(ListNode A) {
        if(A == null) {
            return A;
        }

        ListNode slowP = A;
        ListNode fastP = A;


        while (fastP.next != null && fastP.next.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }

        if(fastP.next == null) {
            return slowP;
        } else {
            return slowP.next;
        }

    }

}

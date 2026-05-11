package com.ksoni.javadukes.LinkedList;

import com.ksoni.javadukes.common.ListNode;

public class LinkedListUtils {

    public static ListNode mergeTwoSortedLists(ListNode A, ListNode B) {
        if(A == null) {
            return B;
        }

        if(B == null) {
            return A;
        }

        ListNode head = null;

        if(A.val <= B.val) {
            head = A;
            A = A.next;
        } else {
            head = B;
            B = B.next;
        }

        ListNode temp = head;

        while (A != null && B != null) {
            if(A.val <= B.val) {
                temp.next = A;
                A = A.next;
            } else {
                temp.next = B;
                B = B.next;
            }
            temp = temp.next;
        }

        if(A == null) {
            temp.next = B;
        }

        if(B == null) {
            temp.next = A;
        }

        return head;
    }

    public static ListNode middleNode(ListNode A) {
        if(A == null) {
            return  null;
        }

        ListNode sp = A;
        ListNode fp = A;

        while (fp.next != null && fp.next.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }

        return sp;
    }
}

package com.ksoni.javadukes.LinkedList;

import com.ksoni.javadukes.common.ListNode;

public class DeleteLinkedList {
    public static void main(String[] args) {

    }

    public ListNode solve(ListNode A, int B) {
        ListNode temp = A;

        if(B == 0) {
            return A.next;
        }

        for (int i = 0; i < B-1; i++) {
            if(temp != null && temp.next != null) {
                temp = temp.next;
            }
        }

        if(temp != null && temp.next != null) {
            temp = temp.next;
        }

        return A;
    }
}

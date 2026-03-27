package com.ksoni.javadukes.LinkedList;

import com.ksoni.javadukes.common.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertLinkedList {
    public static void main(String[] args) {
        ListNode A = new ListNode(8);
        ListNode temp = A;
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(7,7,6,6,3,1,5,7));
        for (int num: list) {
            temp.val = num;
            temp = temp.next;
        }

        InsertLinkedList insertLinkedList = new InsertLinkedList();
        insertLinkedList.solve1(A, 5, 6);
    }

    public ListNode solve1(ListNode head, int value, int position) {
        ListNode tail = head;
        ListNode newNode = new ListNode(value);

        if(head == null) {
            return newNode;
        }

        for (int i = 0; i < position; i++) {
            if (tail != null) {
                tail = tail.next;
            }
        }

        if(tail != null && tail.next != null) {
            newNode.next = tail.next.next;
            tail.next = newNode;
        } else {
            tail.next = newNode;
        }

        return head;

    }

}

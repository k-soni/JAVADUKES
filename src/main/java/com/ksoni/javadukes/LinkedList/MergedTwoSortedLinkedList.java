package com.ksoni.javadukes.LinkedList;

import com.ksoni.javadukes.common.ListNode;

public class MergedTwoSortedLinkedList {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode AHead = A;
        ListNode BHead = B;
        ListNode ansList = null;

        if(AHead.val <= BHead.val) {
            ansList = A;
            AHead = AHead.next;
        } else {
            ansList = B;
            BHead = BHead.next;
        }

        ListNode temp = ansList;

        while (AHead != null && BHead != null) {
            if(AHead.val <= BHead.val) {
                temp.next = AHead;
                AHead = AHead.next;
            } else {
                temp.next = BHead;
                BHead = BHead.next;
            }
            temp = temp.next;
        }

        if(AHead.next == null) {
            temp.next = BHead;
        }
        if(BHead.next == null) {
            temp.next = AHead;
        }

        return ansList;
    }
}

package com.ksoni.javadukes.LinkedList;

import com.ksoni.javadukes.common.ListNode;

public class SortLinkedList {

    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode A) {
        if(A == null || A.next == null ) {
            return A;
        }

        ListNode midNode = LinkedListUtils.middleNode(A);
        ListNode head2 = midNode.next;
        midNode.next = null;

        ListNode l1 = sortList(A);
        ListNode l2 = sortList(head2);
        return LinkedListUtils.mergeTwoSortedLists(l1, l2);
    }


}

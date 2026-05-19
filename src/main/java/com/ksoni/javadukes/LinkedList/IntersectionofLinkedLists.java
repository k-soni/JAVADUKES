package com.ksoni.javadukes.LinkedList;

import com.ksoni.javadukes.common.ListNode;

public class IntersectionofLinkedLists {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode A, ListNode B) {

        int lA = 0;
        int lB = 0;
        ListNode ptr1 = A;
        ListNode ptr2 = B;
        ListNode temp1 = A;
        ListNode temp2 = B;

        if(A == null || B == null) {
            return null;
        }

        while (temp1 != null) {

            temp1 = temp1.next;
            lA++;
        }

        while (temp2 != null) {
            temp2 = temp2.next;
            lB++;
        }

        if(lA > lB) {
            int diff = lA - lB;
            for (int i = 0; i < diff; i++) {
                ptr1 = ptr1.next;
            }
        } else {
            int diff = lB - lA;
            for (int i = 0; i < diff; i++) {
                ptr2 = ptr2.next;
            }
        }

        while (ptr1 != null && ptr2 !=null) {
            if(ptr1 == ptr2) {
                return ptr1;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        if(ptr1 == ptr2) {
            return ptr1;
        } else {
            return null;
        }
    }

}

package com.ksoni.javadukes.LinkedList;

import com.ksoni.javadukes.common.ListNode;

public class FindingKElement {
    public static void main(String[] args) {

    }

    public int solve(ListNode A, int B) {
        ListNode temp = A;

        for (int i = 0; i < B; i++) {
            if(temp.next != null) {
                temp = temp.next;
            }
        }

        if(temp.val == B) {
            return temp.val;
        }
        return -1;
    }
}

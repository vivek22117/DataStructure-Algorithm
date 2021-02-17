package com.ds.algo.examples.practice3;

public class MergeTwoSortedLinkList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwo(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode head = result;

        while (l1 != null && l2 != null) {

            if(l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
        }

        if(l1 != null) {
            result.next = l1;
        } else {
            result.next = l2;
        }

        return head.next;
    }
}

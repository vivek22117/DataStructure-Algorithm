package com.ds.algo.examples.practice2.tree;

import java.util.HashSet;
import java.util.Set;

public class LinkListIntersection {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        while (headA != null) {
            visited.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (visited.contains(headB)) {
                return headB;
            }

            headB = headB.next;
        }

        return null;
    }
}

package com.ds.algo.examples.practice3;

import com.ds.algo.examples.practice1.linklist.LinkListDS;

import java.util.List;

public class ReverseLinkList {

    private static ListNode head = null;

    public static void main(String[] args) {
        ReverseLinkList list = new ReverseLinkList();
        ListNode node = new ListNode(19);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(11);
        ListNode node4 = new ListNode(18);
        ListNode node5 = new ListNode(22);
        ListNode node6 = new ListNode(23);


        head = node;
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        list.printLinkList();

        ListNode reverse = list.reverse(head);
        head = reverse;
        list.printLinkList();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode node) {
            val = x;
            next = node;
        }

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public void printLinkList() {
        ListNode current = head;
        while (current != null){
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("Null");
        System.out.println("Printing Done...!!");
    }
}

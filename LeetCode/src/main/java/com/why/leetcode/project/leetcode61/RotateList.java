package com.why.leetcode.project.leetcode61;


import com.why.leetcode.pojo.ListNode;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class RotateList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 2;
        ListNode listNode = rotateRight(head, k);
        for (ListNode p = listNode; p != null; p = p.next) {
            System.out.println(p.val);
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int count = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            count++;
        }
        tail.next = head;
        k %= count;
        for (int i = 1; i <= count - k; i++) {
            tail = tail.next;
        }
        ListNode newHead = tail.next;
        tail.next = null;

        return newHead;

    }
}

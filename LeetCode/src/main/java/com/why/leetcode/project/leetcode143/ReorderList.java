package com.why.leetcode.project.leetcode143;

import com.why.leetcode.pojo.ListNode;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 示例 2：
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1 , new ListNode(2 , new ListNode(3 , new ListNode( 4 , new ListNode(5)))));
        reorderList(node);
    }

    public static void reorderList(ListNode head) {
        if (head == null) return;
        ListNode m = mid(head);
        ListNode l1 = head;
        ListNode l2 = m.next;
        m.next = null;
        l2 = reverse(l2);
        merge(l1 , l2);

//        while (head != null){
//            System.out.println(head.val);
//            head = head.next;
//        }
    }

    //反转链表
    public  static ListNode reverse(ListNode head){
        ListNode pre = null , curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    //寻找链表中间节点
    public  static ListNode mid(ListNode head){
        ListNode fast = head , slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //合并两个链表
    public  static void merge(ListNode l1 , ListNode l2) {
        ListNode list_node1;
        ListNode list_node2;
        while (l1 != null && l2 != null) {
            list_node1 = l1.next;
            list_node2 = l2.next;

            l1.next = l2;
            l1 = list_node1;

            l2.next = l1;
            l2 = list_node2;
        }
    }
}

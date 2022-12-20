package com.why.leetcode.project.leetcode25;


import com.why.leetcode.pojo.ListNode;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 */
public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        ListNode node = new ListNode(1 , new ListNode(2 , new ListNode(3 , new ListNode(4 , new ListNode(5)))));
        ListNode listNode = reverseKGroup(node, 2);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while(end.next != null){
            for(int i = 0 ; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode next = end.next;
            ListNode start = pre.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            end = start;
            pre = end;
        }
        return dummy.next;
    }

    public static ListNode reverse(ListNode head){
        ListNode pre = null , curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}

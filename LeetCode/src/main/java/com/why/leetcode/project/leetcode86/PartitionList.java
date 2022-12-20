package com.why.leetcode.project.leetcode86;

import com.why.leetcode.pojo.ListNode;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * 示例 1：
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 */
public class PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2,new ListNode(4,new ListNode(3,new ListNode(2, new ListNode(5))))));
        int x = 3;

    }
    public static ListNode partition(ListNode head, int x) {
        ListNode samll = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode s = samll , b = big , h = head;
        while(h != null){
            if(h.val < x){
                s.next = h;
                s = s.next;
            }else{
                b.next = h;
                b = b.next;
            }
            h = h.next;
        }
        b.next = null;
        s.next = big.next;
        return samll.next;
    }
}

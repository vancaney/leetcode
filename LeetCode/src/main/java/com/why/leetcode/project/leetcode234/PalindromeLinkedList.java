package com.why.leetcode.project.leetcode234;

import com.why.leetcode.pojo.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1 , new ListNode(2,new ListNode(2 , new ListNode(3))));
        boolean palindrome = isPalindrome(head);
    }
    public static boolean isPalindrome(ListNode head) {
        ListNode h = head;
        List<Integer> list = new ArrayList<>();
        while(h != null){
            list.add(h.val);
            h = h.next;
        }

        int l = 0 , r = list.size() - 1;
        while(l < r){
            if(list.get(l) != list.get(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

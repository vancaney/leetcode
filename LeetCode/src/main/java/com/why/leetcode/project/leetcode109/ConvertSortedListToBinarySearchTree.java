package com.why.leetcode.project.leetcode109;

import com.why.leetcode.pojo.ListNode;
import com.why.leetcode.pojo.TreeNode;

/**
 * 给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。
 * 示例 1:
 * 输入: head = [-10,-3,0,5,9]
 * 输出: [0,-3,9,-10,null,5]
 * 解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
 * 示例 2:
 * 输入: head = []
 * 输出: []
 */
public class ConvertSortedListToBinarySearchTree {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
        TreeNode treeNode = sortedListToBST(listNode);
        System.out.println(treeNode);
    }

    public static TreeNode sortedListToBST(ListNode head) {
        return buildTreeNode(head, null);
    }

    public static TreeNode buildTreeNode(ListNode left, ListNode right) {
        if (left == right)
            return null;

        ListNode mid = getMedian(left, right);

        TreeNode root = new TreeNode(mid.val);

        root.left = buildTreeNode(left, mid);
        root.right = buildTreeNode(mid.next, right);

        return root;
    }

    public static ListNode getMedian(ListNode head, ListNode right) {
        ListNode fast = head, slow = head;
        while (fast.next != right && fast.next.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}



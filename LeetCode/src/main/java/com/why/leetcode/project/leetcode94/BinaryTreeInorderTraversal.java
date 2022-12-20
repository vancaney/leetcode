package com.why.leetcode.project.leetcode94;

import com.why.leetcode.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序遍历 。
 *      1
 *    /   \
 * null    2
 *        /
 *       3
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> integers = inorderTraversal(treeNode);
        integers.forEach(System.out::println);
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root , res);
        return res;
    }

    public static void inorder(TreeNode root , List<Integer> list){
        if(root == null) return;
        inorder(root.left , list);
        list.add(root.val);
        inorder(root.right , list);
    }
}

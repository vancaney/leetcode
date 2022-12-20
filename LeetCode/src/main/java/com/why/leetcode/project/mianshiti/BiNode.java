package com.why.leetcode.project.mianshiti;

import com.why.leetcode.pojo.TreeNode;

public class BiNode {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4 , new TreeNode(2 , new TreeNode(1 , new TreeNode(0) , null) , new TreeNode(3)) , new TreeNode(5 , null , new TreeNode(6)));
        TreeNode treeNode1 = convertBiNode(treeNode);
        System.out.println(treeNode1);
    }

    static TreeNode head = new TreeNode(-1);
    static TreeNode pre = head;
    public static TreeNode convertBiNode(TreeNode root) {
        buildTreeNode(root);
        return head.right;
    }

    public static void buildTreeNode(TreeNode root){
        if(root == null) return;
        buildTreeNode(root.left);
         pre.right = root;
         pre = root;
         root.left = null;
        buildTreeNode(root.right);
    }

}


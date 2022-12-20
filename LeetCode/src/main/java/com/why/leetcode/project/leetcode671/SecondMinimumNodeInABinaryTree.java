package com.why.leetcode.project.leetcode671;

import com.why.leetcode.pojo.TreeNode;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。
 * 如果第二小的值不存在的话，输出 -1 。
 * 示例 1：
 *      2
 *    /  \
 *   2    5
 *  / \
 * 5   7
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 * 示例 2：
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 */
public class SecondMinimumNodeInABinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2, new TreeNode(2), new TreeNode(5, new TreeNode(5), new TreeNode(7)));
        int secondMinimumValue = findSecondMinimumValue(treeNode);
        System.out.println(secondMinimumValue);
    }

    static int res;
    static int rootValue;
    public static int findSecondMinimumValue(TreeNode root) {
        res = -1;
        rootValue = root.val;
        dfs(root);
        return res;
    }

    public static void dfs(TreeNode root) {
        if (root == null) return;

        if (res != -1 && root.val >= res) return;
        if (root.val > rootValue) res = root.val;

        dfs(root.left);
        dfs(root.right);
    }


/*        public static int findSecondMinimumValue(TreeNode root) {
        return dfs(root, root.val);
    }

    public static int dfs(TreeNode root, int val) {
        if (root == null)
            return -1;
        if (root.val > val)
            return root.val;
        int l = dfs(root.left, val);
        int r = dfs(root.right, val);
        return Math.max(l, r);
    }*/
}

package com.why.leetcode.project.leetcode921;


/**
 * 只有满足下面几点之一，括号字符串才是有效的：
 * 它是一个空字符串，或者
 * 它可以被写成AB（A与B连接）, 其中A 和B都是有效字符串，或者
 * 它可以被写作(A)，其中A是有效字符串。
 * 给定一个括号字符串 s ，移动N次，你就可以在字符串的任何位置插入一个括号。
 * 例如，如果 s = "()))" ，你可以插入一个开始括号为 "(()))" 或结束括号为 "())))" 。
 * 返回 为使结果字符串 s 有效而必须添加的最少括号数。
 * 示例 1：
 * 输入：s = "())"
 * 输出：1
 * 示例 2：
 * 输入：s = "((("
 * 输出：3
 */
public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        String s = "()))((";
    }

    public int minAddToMakeValid(String s) {
        int left = 0 , right = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '(') left++;
            else{
                if(left != 0) left--;
                else right++;
            }
        }
        return left + right;
    }
}

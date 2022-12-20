package com.leetcode.project.leetcode856;

import java.util.*;

/**
 * 给定一个平衡括号字符串S，按下述规则计算该字符串的分数：
 * () 得 1 分。
 * AB 得A + B分，其中 A 和 B 是平衡括号字符串。
 * (A) 得2 * A分，其中 A 是平衡括号字符串。
 * 示例 1：
 * 输入： "()"
 * 输出： 1
 * 示例 2：
 * 输入： "(())"   得2 * 1分
 * 输出： 2
 * 示例3：
 * 输入： "()()"
 * 输出： 2
 * 示例4：
 * 输入： "(()(()))"  = (())  +  ((()))
 * 输出： 6             2^1       2^2 = 4
 */
public class ScoreOfParentheses {

    public static void main(String[] args) {
        String s = "(())";
        System.out.println(scoreOfParentheses(s));
    }
//    public static int scoreOfParentheses(String s) {
//        Deque<Integer> d = new ArrayDeque<>();
//        d.addLast(0);
//        for (char c : s.toCharArray()) {
//            if (c == '(') d.addLast(0);
//            else {
//                int cur = d.pollLast();
//                d.addLast(d.pollLast() + Math.max(cur * 2 , 1));
//            }
//        }
//        return d.peekLast();
//    }

    public static int scoreOfParentheses(String s) {
        int res = 0 , count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                count++;
            }else{
                count--;
                if(s.charAt(i - 1) == '('){
                    res += 1 << count;
                }
            }
        }
        return res;
    }
}

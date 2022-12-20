package com.why.leetcode.project.leetcode1796;

import java.util.Arrays;

/**
 * 给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
 * 混合字符串 由小写英文字母和数字组成。
 * 示例 1：
 * 输入：s = "dfa12321afd"
 * 输出：2
 * 解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
 * 示例 2：
 * 输入：s = "abc1111"
 * 输出：-1
 * 解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
 */
public class SecondLargestDigitInAString {
    public static void main(String[] args) {
        String s = "dfa12321afd";
        secondHighest(s);
    }

    public static int secondHighest(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);

        if(ch[0] == 'a') return -1;

        int res = -1 , count = 0;
            for(int i = 1 ; i < ch.length ; i++){
                if(count == 2) return res;
                if(count != 2 && ch[i] > '9'){
                    return -1;
                }else {
                    if(res == ch[i]) continue;
                    res = Math.max(res , ch[i]);
                    count++;
                }
            }
        return res - '0';
    }
    public int secondHighest1(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        int b = -1 , a = -1;
        for(int i = 0 ; i < ch.length - 1 ; i++){
            char c = ch[i];
            if(c <= '9'){
                if(b == c) continue;
                a = b;
                b = c;
            }
        }
        if(a == -1) return a;
        return a - '0';
    }
}

package com.why.leetcode.project.leetcode784;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串s，通过将字符串s中的每个字母转变大小写，我们可以获得一个新的字符串。
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 * 示例 1：
 *
 * 输入：s = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * 示例 2:
 *
 * 输入: s = "3z4"
 * 输出: ["3z4","3Z4"]
 */
public class LetterCasePermutation {
    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println(letterCasePermutation(s));
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        dfs(arr, 0, res);
        return res;
    }

    public static void dfs( char[] ch,int index, List<String> res) {
        if (index == ch.length) {
            res.add(new String(ch));
            return;
        }

        dfs( ch, index + 1, res);

        if (Character.isLetter(ch[index])) {
            ch[index] ^= 32;
            dfs( ch, index + 1, res);
        }
    }

    public static void dfs1(char[] arr, int pos, List<String> res) {
        while (pos < arr.length && Character.isDigit(arr[pos])) {
            pos++;
        }
        if (pos == arr.length) {
            res.add(new String(arr));
            return;
        }
        arr[pos] ^= 32;
        dfs1(arr, pos + 1, res);
        arr[pos] ^= 32;
        dfs1(arr, pos + 1, res);
    }
}

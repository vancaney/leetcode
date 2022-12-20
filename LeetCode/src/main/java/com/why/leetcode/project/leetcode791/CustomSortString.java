package com.why.leetcode.project.leetcode791;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定两个字符串 order 和 s 。order 的所有单词都是 唯一 的，并且以前按照一些自定义的顺序排序。
 * 对 s 的字符进行置换，使其与排序的 order 相匹配。更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x 也应该出现在 y 之前。
 * 返回 满足这个性质的 s 的任意排列 。
 * 示例 1:
 * 输入: order = "cba", s = "abcd"
 * 输出: "cbad"
 * 解释:
 * “a”、“b”、“c”是按顺序出现的，所以“a”、“b”、“c”的顺序应该是“c”、“b”、“a”。
 * 因为“d”不是按顺序出现的，所以它可以在返回的字符串中的任何位置。“dcba”、“cdba”、“cbda”也是有效的输出。
 * 示例 2:
 * 输入: order = "cbafg", s = "abcd"
 * 输出: "cbad"
 */
public class CustomSortString {

    public static void main(String[] args) {
        String order = "cba", s = "abcd";
        String s1 = customSortString(order, s);
    }

    public static String customSortString(String order, String s) {
        int[] orderIndex = new int[26];
        for(int i = 0 ; i < order.length() ; i++){
            orderIndex[order.charAt(i) - 'a'] = i;
        }
        /*
         * orderIndex = [2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
         * */
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            arr[i] = s.charAt(i);
        }

        //Arrays.sort(arr , (o1 , o2) -> orderIndex[o1 - 'a'] - orderIndex[o2 - 'a']);
        Arrays.sort(arr, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return orderIndex[o1 - 'a'] - orderIndex[o2 - 'a'];
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < arr.length ; i++){
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}

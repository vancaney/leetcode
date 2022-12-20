package com.why.leetcode.project.leetcode844;

/**
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * 示例 1：
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 * 示例 2：
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 * 示例 3：
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
//        String s = "bxj##tw";
//        String t ="bxj###tw";
        String s = "ab##", t = "c#d#";
        System.out.println(backspaceCompare(s, t));
    }
    public static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1 , j = t.length() - 1;
        int skipS = 0 , skipT = 0;
        while(i >= 0 || j >= 0){
            while(i >= 0){
                if(s.charAt(i) == '#'){
                    i--;
                    skipS++;
                }else if(skipS > 0){
                    i--;
                    skipS--;
                }else{
                    break;
                }
            }

            while(j >= 0){
                if(t.charAt(j) == '#'){
                    j--;
                    skipT++;
                }else if(skipT > 0){
                    j--;
                    skipT--;
                }else{
                    break;
                }
            }
            if(i >= 0 && j >= 0){
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            }else {
                if(i >= 0 || j >= 0){
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}

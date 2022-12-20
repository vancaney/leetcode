package com.why.leetcode.project.leetcode777;

/**
 * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。
 * 一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。
 * 现给定起始字符串start和结束字符串end，请编写代码,
 * 当且仅当存在一系列移动操作使得start可以转换成end时,返回True。
 * 示例 :
 * 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * 输出: True
 * 解释:
 * 我们可以通过以下几步将start转换成end:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 */
public class SwapAdjacentInLRString {

    public static void main(String[] args) {
        //String start = "RXXLRXRXL", end = "XRLXXRRLX";
        String start = "XRXXXLXXXR", end = "XXRLXXXRXX";
        System.out.println(canTransform(start , end));
    }

    public static boolean canTransform(String start, String end) {
        int s = 0 , e= 0 , len = start.length();
        while (s < len || e < len){
            while (s < len && start.charAt(s) == 'X')
                s++;
            while (e < len && end.charAt(e) == 'X')
                e++;
            if (s == len || e == len) break;
            //start = "LLR", end = "RRL";
            if (start.charAt(s) != end.charAt(e)) return false;
            //start = "LXXLXRLXXL" end = "XLLXRXLXLX";
            if (s < e && start.charAt(s) == 'L') return false;
            //start = "XRXXXLXXXR" end = "XXRLXXXRXX";
            if (s > e && end.charAt(e) == 'R') return false;
            s++;
            e++;
        }
        return e == s;
    }
}

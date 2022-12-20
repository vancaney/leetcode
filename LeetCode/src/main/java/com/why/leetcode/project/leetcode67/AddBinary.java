package com.why.leetcode.project.leetcode67;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * 示例 1：
 * 输入:a = "11", b = "1"
 * 输出："100"
 * 示例 2：
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 */

public class AddBinary {
    public static void main(String[] args) {
        String a = "1", b = "111";
        System.err.println(addBinary(a, b));
    }

/*    //解法一：
        public static String addBinary(String a, String b) {
        // 将字符串"11"看成2进制的11，并按10进制输出整数
        return Integer.toBinaryString(Integer.parseInt(a , 2) + Integer.parseInt(b , 2));
    }*/

    //解法二：
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aLen = a.length() , bLen = b.length();

        String zero = "";
        for(int i = 0 ; i < Math.abs(aLen - bLen) ; i++){
            zero += "0";
        }

        if(aLen < bLen) a = zero + a;
        else b = zero + b;

        String carry = "";
        int newalen = a.length();
        for(int i = newalen - 1 ; i >= 0 ; i--){
            if(a.charAt(i) - '0' == 0 && b.charAt(i) - '0' == 0){
                if(carry.equals(""))
                    sb.append("0");
                else{
                    carry = "";
                    sb.append("1");
                }
            }else if((a.charAt(i) - '0' == 1 && b.charAt(i) - '0' == 0)
                    || (a.charAt(i) - '0' == 0 && b.charAt(i) - '0' == 1)){
                sb = carry.equals("") ? sb.append("1") : sb.append("0");
            }else{
                if(carry.equals("")){
                    carry = "1";
                    sb.append("0");
                }else{
                    sb.append("1");
                }
            }
        }
        if(carry.equals("1")) sb.append("1");

        return sb.reverse().toString();
    }
}

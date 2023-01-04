//package com.test;
//
//import com.why.leetcode.pojo.ListNode;
//import org.junit.Test;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.*;
//import java.util.function.BiConsumer;
//import java.util.function.BiFunction;
//import java.util.function.Consumer;
//
//public class test01 {
//    @Test
//    public void test() {
//        String s = "4 5 11 26";
//        System.err.println(areNumbersAscending(s));
//    }
//
//    public boolean areNumbersAscending(String s) {
//        int n = 0 , j = -1;
//        for(int i = 0 ; i < s.length() - 1 ; i++){
//            char c = s.charAt(i);
//            if(Character.isDigit(c)){
//                n += c - '0';
//                if(Character.isDigit(s.charAt(i + 1)))
//                    n *= 10;
//                else{
//                    if(j < n){
//                        j = n;
//                        n = 0;
//                    }
//                }
//            }else
//                continue;
//        }
//        return j == n;
//    }
//
//}

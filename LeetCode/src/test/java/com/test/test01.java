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
//        int s = 30;
//        System.err.println(countEven(s));
//    }
//
//    public int countEven(int num) {
//        int res = 0;
//        for(int i = 1 ; i <= num ;i++){
//            if(getsum(i)) {
//                System.out.println(i);
//                res++;
//            }
//            else continue;
//        }
//        return res;
//    }
//
//    public boolean getsum(int n){
//        int i = n , temp = 0 , ans = 0;
//        while(i > 0){
//            temp = i % 10;;
//            ans += temp;
//            i /= 10;
//        }
//        return temp % 2 == 0;
//    }
//
//}

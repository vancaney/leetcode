//package com.test;
//
//import com.why.leetcode.pojo.ListNode;
//import org.junit.Test;
//
//import java.util.*;
//import java.util.function.BiConsumer;
//import java.util.function.BiFunction;
//
//public class test01 {
//    @Test
//    public void test() {
//        int[] nums1 = {1,1,3,2} , nums2 = {2,3}, nums3 = {3};
//        twoOutOfThree(nums1 , nums2 , nums3);
//    }
//
//    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
//        List<Integer> result = new ArrayList<>();
//        Map<Integer , Integer> map1 = new HashMap<>();
//        for(int n : nums1)
//            map1.put(n , 1);
//
//        Map<Integer , Integer> map2 = new HashMap<>();
//        for(int n : nums2)
//            map2.put(n , 1);
//
//        Map<Integer , Integer> map3 = new HashMap<>();
//        for(int n : nums3)
//            map3.put(n , 1);
//
//        map2.forEach((k, v) -> map1.merge(k, v, Integer::sum));
//        map3.forEach((k, v) -> map1.merge(k, v, Integer::sum));
//
//        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
//            if(entry.getValue() >= 2)
//                result.add(entry.getKey());
//        }
//        return result;
//    }
//
//}

//package com.test;
//
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class test01 {
//    @Test
//    public void test() {
//        int[] nums = {1,2,3};
//        System.out.println(permute(nums));
//    }
//    List<List<Integer>> res = new ArrayList<>();
//    List<Integer> curr = new ArrayList<>();
//    public List<List<Integer>> permute(int[] nums) {
//        dfs(nums , 0);
//        return res;
//    }
//
//    public void dfs(int[] nums , int index){
//        if(curr.size() == nums.length){
//            res.add(new ArrayList<Integer>(curr));
//            return;
//        }
//        for(int i = index ; i < nums.length ; i++){
//            if(curr.contains(nums[i])) continue;
//            curr.add(nums[i]);
//            dfs(nums , i);
//            curr.remove(curr.size() - 1);
//        }
//    }
//}

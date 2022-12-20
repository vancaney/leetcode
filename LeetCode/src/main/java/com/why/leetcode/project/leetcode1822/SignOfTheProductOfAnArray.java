package com.why.leetcode.project.leetcode1822;

import java.math.BigInteger;

/**
 * 已知函数signFunc(x) 将会根据 x 的正负返回特定值：
 * 如果 x 是正数，返回 1 。
 * 如果 x 是负数，返回 -1 。
 * 如果 x 是等于 0 ，返回 0 。
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 * 返回 signFunc(product) 。
 * 示例 1：
 * 输入：nums = [-1,-2,-3,-4,3,2,1]
 * 输出：1
 * 解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
 * 示例 2：
 * 输入：nums = [1,5,0,2,-3]
 * 输出：0
 * 解释：数组中所有值的乘积是 0 ，且 signFunc(0) = 0
 * 示例 3：
 * 输入：nums = [-1,1,-1,1,-1]
 * 输出：-1
 * 解释：数组中所有值的乘积是 -1 ，且 signFunc(-1) = -1
 * 提示：
 * 1 <= nums.length <= 1000
 * -100 <= nums[i] <= 100
 */
public class SignOfTheProductOfAnArray {

    public static void main(String[] args) {
        int[] arr = new int[]{9,72,34,29,-49,-22,-77,-17,-66,-75,-44,-30,-24};
        System.out.println(arraySign(arr));
        System.out.println(arraySign1(arr));
    }
    public static int arraySign(int[] nums) {
        BigInteger integer = BigInteger.valueOf(1);
        for(int i = 0 ; i < nums.length ; i++){
            integer = integer.multiply(BigInteger.valueOf(nums[i]));
            if(integer.intValue() == 0) return 0;
        }
        int i = integer.compareTo(BigInteger.valueOf(0));
        return i;
    }

    public static int arraySign1(int[] nums) {
        int num = 1;
        for (int i : nums) {
            if (i == 0) return 0;
            if (i > 0) num *= 1;
            else num *= -1;
        }
        return num;
    }

    public static int arraySign2(int[] nums) {
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] < 0) count++;
            else if(nums[i] == 0) return 0;
            else continue;
        }
//        if(count % 2 != 0) return -1;
//        return 1;
        return count % 2 != 0 ? -1 : 1;
    }
}

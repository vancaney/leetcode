package com.leetcode.project.leetcode870;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 * 示例 1：
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 示例 2：
 * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * 输出：[24,32,8,12]
 */
public class AdvantageShuffle {

    public static void main(String[] args) {
        int[] nums1 =new int[]{2,7,11,15} , nums2 = new int[]{1,10,4,11};
        advantageCount(nums1 , nums2);
    }

    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int len = nums1.length;
        Integer[] arrIndex = new Integer[len];
        //arrIndex = {0,1,2,3}
        for(int i = 0 ; i < len ; i++){
            arrIndex[i] = i;
        }

        //排序后 arrIndex = {3,1,2,0}
        //Arrays.sort(arrIndex , (o1 , o2) -> nums2[o2] - nums2[o1]);
        Arrays.sort(arrIndex, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //System.out.println(o1 + " " + o2);
                return nums2[o2] - nums2[o1];
            }
        });
//        for (Integer index : arrIndex) {
//            System.out.println(index);
//        }
        Arrays.sort(nums1);

        int[] res = new int[len];
        int r = nums1.length - 1 , l = 0;
        for(int index : arrIndex){
            if(nums2[index] >= nums1[r]){
                res[index] = nums1[l];
                l++;
            }else{
                res[index] = nums1[r];
                r--;
            }
        }
        return res;
    }
}

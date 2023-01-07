package com.test;

import com.why.leetcode.project.leetcode2180.CountIntegersWithEvenDigitSum;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test01 {

    public Object getClassAnyMethod(Object obj , String methodName , Class<?> returnType , Object...args){
        try {
            Class<?> aClass = obj.getClass();
            Method method = aClass.getDeclaredMethod(methodName, returnType);
            return method.invoke(obj , args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void test() throws Exception {
        minOperations(new int[]{8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309} , 134365);
    }

    public int minOperations(int[] nums, int x) {
        int target = 0;
        for(int n : nums){
            target += n;
        }
        System.out.println(target);
        if(target < x) return -1;

        int len = nums.length , l = 0 , r = len - 1 , res = 0;
        while(l < r){
            if(x == 0) break;
            else if(x < 0) return -1;
            if(nums[l] < nums[r] && nums[r] <= x){
                x -= nums[r];
                r--;
                res++;
            }else if(nums[l] > nums[r] && nums[l] <= x){
                x -= nums[l];
                l++;
                res++;
            }
        }
        return res;
    }

}

package com.why.leetcode.project.leetcode927;


public class ThreeEqualParts {

    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1};
        int[] res = threeEqualParts(arr);
        for (int i : res) {
            System.out.println(i);
        }
    }
    public static int[] threeEqualParts(int[] arr) {
        int sum = 0 , len = arr.length;
        for(int i = 0 ; i < len ; i++){
            sum += arr[i];
        }
        if(sum % 3 != 0) return new int[] {-1 , -1};
        if(sum == 0) return new int[]{0,2};
        int pretail = sum / 3;
        int first = 0 , second = 0 , third = 0 , curr = 0;
        for(int i = 0 ; i < len ; i++){
            if(arr[i] == 1){
                if(curr == 0){
                    first = i;
                }else if(curr == pretail){
                    second = i;
                }else if(curr == 2 * pretail){
                    third = i;
                }
                curr++;
            }
        }

        int n = arr.length - third;
        if (first + n <= second && second + n <= third) {
            int i = 0;
            while (third + i < arr.length) {
                if (arr[first + i] != arr[second + i] || arr[first + i] != arr[third + i]) {
                    return new int[]{-1, -1};
                }
                i++;
            }
            return new int[]{first + n - 1, second + n};
        }
        return new int[]{-1, -1};
    }
}

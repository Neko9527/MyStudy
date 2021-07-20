package com.xcw.practice;

import java.util.Arrays;

/**
 * @author wangxuechao
 * @date 2021-07-19
 */
public class LC1877 {

    public static void main(String[] args) {
        System.out.println(minPairSum(new int[]{3,5,4,2,4,6}));
    }

    public static int minPairSum(int[] nums) {


        Arrays.sort(nums);

        int max = 0;
        int left = 0; int right = nums.length - 1;
        while (left < right) {
            max = Math.max(max,nums[left] + nums[right]);
            left++;
            right--;
        }
        return max;
    }
}

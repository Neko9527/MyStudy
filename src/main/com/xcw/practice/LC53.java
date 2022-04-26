package com.xcw.practice;

/**
 * @author wangxuechao
 * @date 2022/4/25
 */
public class LC53 {

    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {

        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

}

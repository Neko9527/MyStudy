package com.xcw.practice;

/**
 * @author wangxuechao
 * @date 2021-06-08
 */
public class LC494 {

    static int count = 0;

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        findTargetSum(nums,target,0,0);
        return count;
    }

    public static void findTargetSum(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            findTargetSum(nums, target, index + 1, sum + nums[index]);
            findTargetSum(nums, target, index + 1, sum - nums[index]);
        }
    }
}

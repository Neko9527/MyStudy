package com.xcw.practice;

/**
 * @author wangxuechao
 * @date 2021-07-08
 */
public class LC930 {

    public static void main(String[] args) {

        System.out.println(numSubarraysWithSum(new int[]{0, 0, 0, 0, 1}, 2));
    }

    /**
     * 滑动窗口
     * @param nums
     * @param goal
     * @return
     */
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int ret = 0;
        int front = 0, next = 0;
        int sum = 0;
        while (front < nums.length && next < nums.length) {
            if (next >= front) {
                sum += nums[next];
            }
            if (sum > goal) {
                sum = 0;
                front++;
                next = front;
            }else {
                if (sum == goal) {
                    ret++;
                }
                next++;
                if (next >= nums.length && front < nums.length) {
                    front++;
                    sum = 0;
                    next = front;
                }
            }

        }
        return ret;
    }
}

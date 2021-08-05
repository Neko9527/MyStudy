package com.xcw.practice;

import java.util.Arrays;

/**
 * @author wangxuechao
 * @date 2021-08-04
 */
public class LC611 {

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{0, 1, 1, 1}));
    }

    /**
     * 暴力解法
     *
     * @param nums
     * @return
     */
    public static int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int count = 0;

        int first = len - 1;
        int second = first - 1;

        while (first >= 2) {
            int diff = nums[first] - nums[second];
            count = binarySearch(nums, diff, second, count);
            if (second > 1) {
                second--;
            } else {
                first--;
                second = first - 1;
            }
        }
        return count;
    }

    public static int find(int[] nums, int diff, int edge, int count) {
        for (int i = 0; i < edge; i++) {
            if (nums[i] != 0 && nums[i] > diff) {
                count++;
            }
        }
        return count;
    }


    /**
     * 二分法优化版 n^2logn
     * @param nums
     * @param diff
     * @param edge
     * @param count
     * @return
     */
    public static int binarySearch(int[] nums, int diff, int edge, int count) {
        int low = 0;
        int high = edge - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] > diff) {
                high = mid - 1;
            }
            if (nums[mid] <= diff) {
                low = mid + 1;
            }
        }
        count += edge - high - 1;
        return count;
    }
}

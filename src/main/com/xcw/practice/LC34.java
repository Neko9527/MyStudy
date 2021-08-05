package com.xcw.practice;

import java.util.Arrays;

/**
 * @author wangxuechao
 * @date 2021-08-05
 */
public class LC34 {

    public static void main(String[] args) {
        searchRange(new int[]{7},7);
    }

    public static int[] searchRange(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int mid;
        int[] ret = new int[]{-1,-1};
        while (low <= high) {
            mid = (low + high) / 2;
            if(nums[mid] >= target) {
                high = mid - 1;
            }
            if(nums[mid] == target) {
                ret[0] = mid;
            }
            if(nums[mid] < target) {
                low = mid + 1;
            }
        }
        ret[1] = searchRightRange(nums,target);
        System.out.println(Arrays.toString(ret));
        return ret;
    }

    /**
     * 寻找右边界
     * @param nums
     * @param target
     * @return
     */
    public static int searchRightRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        int ret = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if(nums[mid] > target) {
                high = mid - 1;
            }
            if(nums[mid] == target) {
                ret = mid;
            }
            if(nums[mid] <= target) {
                low = mid + 1;
            }
        }
        return ret;
    }
}

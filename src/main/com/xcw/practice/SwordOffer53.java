package com.xcw.practice;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wangxuechao
 * @date 2021-07-16
 */
public class SwordOffer53 {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{},5));
    }

    // N/2
    public static int search(int[] nums, int target) {
        int ret = 0;
        int low = 0, high = nums.length-1;
        while (true) {
            if(low > high || high < 0 || low >= nums.length) {
                break;
            }
            if(nums[low] == target) {
                ret++;
            }
            if(low == high) break;
            if(nums[high] == target) {
                ret++;
            }
            low++;
            high--;

        }
        return ret;
    }

    // N
    public static int search1(int[] nums, int target) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = nums[i] == target ? ++ret : ret;
        }
        return ret;
    }

    /**
     * 二分查找边界
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
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
        return ret[1] >= 0 && ret[0] >= 0 ? ret[1] - ret[0] + 1 : 0;
    }

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

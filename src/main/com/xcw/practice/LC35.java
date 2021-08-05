package com.xcw.practice;


/**
 * @author wangxuechao
 * @date 2021-08-05
 */
public class LC35 {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6},2));
    }

    public static int searchInsert(int[] nums, int target) {
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
                return mid;
            }
            if(nums[mid] < target) {
                low = mid + 1;
            }
        }
        return low;
    }
}

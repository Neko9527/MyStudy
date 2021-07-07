package com.xcw.practice;
/**
 * @author wangxuechao
 * @date 2021-07-07
 */
public class LC26 {

    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(nums);
    }

    /**
     * 双指针法删除有序数组中重复元素
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {

        if(nums.length == 0) {
            return nums.length;
        }
        int front = 0,next = 1;
        while (next < nums.length) {
            if(nums[front] == nums[next]) {
                next++;
            }else {
                front++;
                nums[front] = nums[next];
            }
        }
        return front + 1;
    }
}

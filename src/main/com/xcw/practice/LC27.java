package com.xcw.practice;

/**
 * @author wangxuechao
 * @date 2021-08-11
 */
public class LC27 {
    public static void main(String[] args) {
        System.out.println(removeElement1(new int[]{0,1,2,2,3,0,4,2},2));
    }

    public static int removeElement(int[] nums, int val) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0] == val ? 0 : 1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(val != nums[i]) ++count;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                continue;
            }
            for (int j = i; j < nums.length; j++) {
                if(nums[j] != val) {
                    nums[i] = nums[j];
                    nums[j] = val;
                    break;
                }
            }

        }
        return count;
    }

    /**
     * 双指针法
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement1(int[] nums, int val) {
        int p1 = 0, p2 = 0;
        while (p2 < nums.length) {
            if(nums[p2] != val) {
                nums[p1] = nums[p2];
                p1++;
            }
            p2++;
        }
        return p1;
    }
}

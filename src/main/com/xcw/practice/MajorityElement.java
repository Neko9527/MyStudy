package com.xcw.practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author wangxuechao
 * @date 2021-07-09
 */
public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement1(new int[]{1,2,5,9,5,9,5,5,5}));
    }

    /**
     *
     * 投票算法
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        if(nums.length == 0)return -1;
        if(nums.length == 1) return nums[0];

        int major = -1,count = 0;
        for (int i = 0; i < nums.length; i++) {
            major = count == 0 ? nums[i] : major;
            count = major == nums[i] ? ++count : --count;
        }
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = major == nums[i] ? ++count :count;
        }
        if(count * 2 > nums.length) {
            return major;
        }
        return -1;

    }


    /**
     * hash
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {

        if(nums.length == 0)return -1;

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i],0) + 1;
            map.put(nums[i],count);
            if(count > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;
    }
}

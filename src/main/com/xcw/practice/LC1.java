package com.xcw.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangxuechao
 * @date 2021-05-06
 */
public class LC1 {

    public static void main(String[] args) {
        int[] nums = new int[] {11,15,2,7};
        twoSum(nums,9);
    }


    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int reduce = target - nums[i];
            if(!map.containsKey(reduce)) {
                map.put(nums[i],i);
            }else {
                result[1] = i;
                result[0] = map.get(reduce);
                return result;
            }
        }
        return result;
    }
}

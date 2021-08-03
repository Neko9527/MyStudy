package com.xcw.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangxuechao
 * @date 2021-08-03
 */
public class LC581 {

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{1,2,4,5,3}));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < nums.length; i++) {
            if(arr[i] != nums[i]) {
                list.add(i);
            }
        }
        if(list.size() == 0) return 0;
        return list.get(list.size() - 1) - list.get(0) + 1;
    }
}

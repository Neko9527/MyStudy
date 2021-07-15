package com.xcw.practice;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wangxuechao
 * @date 2021-07-13
 */
public class LC1818 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        System.out.println(minAbsoluteSumDiff1(
                new int[]{1,10,4,4,2,7},
                new int[]{9,3,5,1,7,4}));
        System.out.println(System.currentTimeMillis() - start);

    }

    public static int minAbsoluteSumDiff1(int[] nums1, int[] nums2) {
        int mod = 1000000007;
        if (nums1.length == 0) return 0;
        if (nums1.length == 1) return Math.abs(nums1[1] - nums2[1]);

        int[] arr = new int[nums1.length];

        int sum = 0, item;
        for (int i = 0; i < nums1.length; i++) {
            item = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + item) % mod;
            arr[i] = item;
        }

        int index = 0, targetIndex = 0;
        int max = Integer.MIN_VALUE;

        // 假设需要将nums1[i]替换为nums1[j]能使绝对差值和最小
        // 则需要取j使|nums1[i] - nums2[i]| - |num1[j] - num2[i]|最大
        for (int i = 0; i < nums1.length; i++) {
            if (arr[i] == 0 && arr[i] <= max) {
                continue;
            }
            for (int j = 0; j < nums1.length; j++) {
                int tmp = arr[i] - Math.abs(Math.abs(nums1[j] - nums2[i]));
                if (max < tmp && i != j && tmp > 0) {
                    max = tmp;
                    index = i;
                    targetIndex = j;
                }
            }

        }
        sum = sum - Math.abs(nums1[index] - nums2[index]) + Math.abs(nums1[targetIndex] - nums2[index]);
        return sum;
    }


    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = 1000000007;
        int len = nums1.length;
        if (len == 0) return 0;
        if (len == 1) return Math.abs(nums1[1] - nums2[1]);

        int[] rec = new int[len];
        System.arraycopy(nums1, 0, rec, 0, len);
        Arrays.sort(rec);
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums1.length; i++) {

            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % mod;
            int j = binarySearch(rec, nums2[i]);
            max = Math.max(max,diff - Math.abs(rec[j] - nums2[i]));
            if(i > 0) {
                max = Math.max(max,diff - Math.abs(rec[j - 1] - nums2[i]));
            }
        }

        return sum - max;
    }

    /**
     * 查询rec中和target最接近的
     *
     * @param rec
     * @param target
     * @return
     */
    public static int binarySearch(int[] rec, int target) {
        int high = rec.length - 1;
        int low = 0;

        if (rec[high] < target) {
            return high;
        }
        int mid = (low + high) / 2;
        while (low < mid) {
            if(rec[mid] > target) {
                high = mid;
            }else {
                low = mid;
            }
            mid = (low + high) / 2;
        }
        return high;
    }

}

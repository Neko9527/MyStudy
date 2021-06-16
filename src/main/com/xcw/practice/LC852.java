package com.xcw.practice;


import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxuechao
 * @date 2021-06-15
 */
public class LC852 {

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray1(new int[]{18,29,38,59,98,100,99,98,90}));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int ret = 0;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
                ret = i;
            }
        }
        System.out.println(ret);
        return ret;
    }


    /**
     * 二分法 时间复杂度O(log n)
     * @param arr
     * @return
     */
    public static int peakIndexInMountainArray1(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid = arr.length / 2;
        while (true) {
            if(arr[mid] < arr[right]) {
                left = mid;
            }
            else {
                if(arr[mid] > arr[mid + 1]) {
                    right = mid;
                }else {
                    left = mid;
                }
            }
            mid = (left + right) / 2;
            if(right - left == 1) {
                if(arr[left] > arr[right])
                    return left;
                return right;
            }
        }
    }
}

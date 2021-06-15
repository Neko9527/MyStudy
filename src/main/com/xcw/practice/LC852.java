package com.xcw.practice;



/**
 * @author wangxuechao
 * @date 2021-06-15
 */
public class LC852 {

    public static void main(String[] args) {
      peakIndexInMountainArray(new int[]{1,2,3,4,5});
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
        return ret;
    }
}

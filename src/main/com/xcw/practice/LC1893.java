package com.xcw.practice;

/**
 * @author wangxuechao
 * @date 2021-07-23
 */
public class LC1893 {


    public static void main(String[] args) {
        System.out.println(isCovered(new int[][]{{1,2},{3,4},{5,6}},2,5));
    }

    public static boolean isCovered(int[][] ranges, int left, int right) {
        boolean ret = true;
        for (int i = left; i <= right; i++) {
            for (int j = 0; j < ranges.length; j++) {
                ret = (ranges[j][0] <= i && ranges[j][1] >= i);
                if(ret) break;

            }
            if(!ret)return false;
        }
        return true;
    }
}

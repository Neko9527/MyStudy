package com.xcw.practice;

/**
 * @author wangxuechao
 * @date 2021-05-27
 */
public class LC461 {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1577962638,1727613287));
    }

    public static int hammingDistance(int x, int y) {
        int t1, t2, count = 0;
        for (int i = 0; i < 31; i++) {
            t1 = x & 1;
            t2 = y & 1;
            x = x >> 1;
            y = y >> 1;
            count = t1 != t2 ? count + 1 : count;
        }
        return count;
    }

    public static int hammingDistance1(int x, int y) {
        x = x ^ y;
        int count = 0;
        while (x != 0) {
            count += x & 1;
            x= x >> 1;
        }
        return count;
    }


}

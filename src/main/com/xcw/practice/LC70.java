package com.xcw.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangxuechao
 * @date 2021-08-10
 */
public class LC70 {

    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }

    public static int climbStairs(int n) {
        if (n <= 0) return 0;

        if (n == 1) return 1;

        if (n == 2) return 2;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        int ret = 0;

        for (int i = 3; i <= n; i++) {
            ret = map.get(i - 1) + map.get(i - 2);
            map.put(i, ret);
        }
        return ret;
    }
}

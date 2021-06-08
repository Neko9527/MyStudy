package com.xcw.practice;


import java.util.HashMap;
import java.util.Map;

/**
 * @author wangxuechao
 * @date 2021-06-08
 * <p>
 * 爬楼梯问题
 */
public class WaysToStep {

    public static void main(String[] args) {
        System.out.println(waysToStep(100));
    }

    public static int waysToStep(int n) {
        long m = n;
        Map<Long, Long> map = new HashMap<>();
        map.put(1L, 1L);
        map.put(2L, 2L);
        map.put(3L, 4L);
        for (long i = 4; i <= m; i++) {
            long sum = 0;
            sum += map.get(i - 1) + map.get(i - 2) + map.get(i - 3);
            map.put(i, (sum % 1000000007));
        }
        return map.get(m).intValue();
    }
}

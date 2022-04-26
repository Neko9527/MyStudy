package com.xcw.practice;

import java.util.Stack;

/**
 * @author wangxuechao
 * @date 2022/4/26
 */
public class LC739 {


    /**
     * 每日温度
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        /**
         * 创建一个栈将数组的下标放入栈中，
         * 遍历数组与栈顶的数据进行比较，如果大于栈顶的数据则符合，下标的差值即第几天达到更高的温度
         * 否则将下标加入栈中
         */
        int[] ret = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length;) {
            if(stack.isEmpty() || temperatures[stack.peek()] >= temperatures[i]) {
                stack.push(i);
                i++;
            }else {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
        }
        return ret;
    }
}

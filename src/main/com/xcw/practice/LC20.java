package com.xcw.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author wangxuechao
 * @date 2022/4/26
 */
public class LC20 {

    public static boolean isValid(String s) {

        if(s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if(map.containsKey(c)) {
                if(stack.isEmpty() || stack.pop() != map.get(c)) return false;
            }else
                stack.push(c);
            index++;
        }
        return stack.isEmpty();
    }
}

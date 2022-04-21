package com.xcw.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wangxuechao
 * @date 2022/4/21
 */
public class LC824 {

    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));
    }

    public static String toGoatLatin(String sentence) {

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        StringBuilder builder = new StringBuilder();
        String[] s = sentence.split(" ");
        String suffix = "ma";
        for (int i = 0; i < s.length; i++) {
            suffix+="a";
            if(set.contains(s[i].charAt(0))) {
                s[i] = s[i] + suffix;
            }else {
                s[i] = s[i].substring(1) + s[i].charAt(0) + suffix;
            }
            s[i] = i == s.length - 1 ? s[i] : s[i] + " ";
        }
        Arrays.stream(s).forEach(str -> builder.append(str));
        return builder.toString();
    }
}

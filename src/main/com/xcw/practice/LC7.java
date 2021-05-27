package com.xcw.practice;

/**
 * @author wangxuechao
 * @date 2021-04-29
 */
public class LC7 {

    public static void main(String[] args) {
        System.out.println(reverse1(120));
    }

    public static int reverse(int x) {
        if(x == 0) return x;
        String s = String.valueOf(x);
        StringBuffer sb = new StringBuffer();
        String pre = "";
        if(x < 0){
            s = s.substring(1);
            sb.append(s);
            pre = "-";
        }else{
            sb.append(s);
        }

        s = sb.reverse().toString();
        if(s.startsWith("0")) s = s.substring(1);
        s = pre + s;

        String s1 = Integer.MAX_VALUE + "";
        String s2 = Integer.MIN_VALUE + "";
        if(s.length() < s1.length()) return Integer.valueOf(s).intValue();
        if(s.startsWith("-") && s.charAt(1) >= s2.charAt(1) && Integer.valueOf(s.substring(2)).intValue() > Integer.valueOf(s2.substring(2))) {
            return 0;
        }

        if(!s.startsWith("-") && s.charAt(0) >= s2.charAt(0) && Integer.valueOf(s.substring(1)).intValue() > Integer.valueOf(s1.substring(1))) {
            return 0;
        }
        return Integer.valueOf(s).intValue();

    }

    public static int reverse1(int x) {
        int result = 0;
        while (x != 0) {
            if(result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            result = result * 10 + digit;
        }
        return result;
    }


}

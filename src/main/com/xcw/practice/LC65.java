package com.xcw.practice;

/**
 * @author wangxuechao
 * @date 2021-06-18
 */
public class LC65 {

    public static void main(String[] args) {

//        String s[] = new String[]{"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
//        String s1[] = new String[]{"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
//        for (int i = 0; i < s.length; i++) {
//            System.out.println(isNumber(s[i]));
//        }
        System.out.println(isNumber(".e1"));
    }

    /**
     * 注意各种条件
     * 46.e3 = true
     * 46.e = false
     * @param s
     * @return
     */
    public static boolean isNumber(String s) {
        if(s.trim().length() == 0) {
            return false;
        }
        if(s.equals(".") || s.equals("+") || s.equals("+")) {
            return false;
        }
        //正负符号位数
        int x = 0;
        //小数点位数
        int point = 0;
        // e的位数
        int y = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case '-' :
                case '+' :
                    if(i == 0 && i + 1 < arr.length && (arr[i + 1] == 'e' || arr[i + 1] == 'E') ) {
                        return false;
                    }
                    if(i != 0) {
                        x+=1;
                        if(x >= 2) {
                            return false;
                        }
                        if((arr[i - 1] == 'e' || arr[i - 1] == 'E') && (i + 1) < arr.length && arr[i + 1] >= 48 && arr[i + 1] <= 57) {
                            continue;
                        }
                        return false;
                    }
                case '0' :
                case '1' :
                case '2' :
                case '3' :
                case '4' :
                case '5' :
                case '6' :
                case '7' :
                case '8' :
                case '9' :
                    continue;
                case 'E' :
                case 'e' :
                    if(++y >= 2) {
                        return false;
                    }
                    if(i == 0 || i + 1 >= s.length()) {
                        return false;
                    }
                    //E后面必须是整数
                    if(s.substring(i+1).lastIndexOf(".") != -1) {
                        return false;
                    }
                    continue;
                case '.' :
                    if(++point >= 2) {
                        return false;
                    }
                    //至少一位数字，后面跟着一个点
                    //例如1. true 而 1.e false
                    if(i + 1 < arr.length && (arr[i + 1] =='e' || arr[i + 1] == 'E')) {
                        if(i + 1 == arr.length - 1) {
                            return false;
                        }
                    }
                    if(i == 0  && (arr[i + 1] =='e' || arr[i + 1] == 'E')) {
                      return false;
                    }
                    if(i == 1 && (arr[0] == '+' || arr[0] == '-') && i + 1 >= arr.length) {
                        return false;
                    }
                    continue;
                default:
                    return false;
            }
        }
        return true;
    }
}

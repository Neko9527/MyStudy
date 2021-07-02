package com.xcw.practice;

/**
 * @author wangxuechao
 * @date 2021-07-01
 * Excel表列名称
 */
public class LC168 {

    public static void main(String[] args) {

        System.out.println(test(52));
    }

    //65-90

    /**
     * 由于没有 0 所以在整除时要向高位借 1
     * @param columnNumber
     * @return
     */
    public static String test(int columnNumber) {
        StringBuilder str = new StringBuilder();
        while (columnNumber != 0) {
            int mod = columnNumber % 26;
            char c = mod == 0 ? 'Z' : (char) (mod + 64);
            columnNumber /= 26;
            str.append(c);
            columnNumber = mod == 0 ? --columnNumber : columnNumber;
        }
        return str.reverse().toString();
    }
}

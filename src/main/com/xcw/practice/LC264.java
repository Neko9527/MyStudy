package com.xcw.practice;

/**
 * @author wangxuechao
 * @date 2021-08-09
 */
public class LC264 {

    public static void main(String[] args) {
        System.out.println(isUgly1(35));
    }

    public static int nthUglyNumber(int n) {
        if(n == 1) return 1;
        int i = 0;
        int m = 1;
        while (true) {
            if(isUgly(m) || m == 1)++i;
            if(i == n)break;
            m++;
        }
        return m;
    }

    /**
     * 如果n为丑数，那么n一定可以被{2，3，5}中一个数整除
     * @param n
     * @return
     */
    public static boolean isUgly1(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }

    public static boolean isUgly(int n) {
        boolean bool = true;
        if(n % 2 != 0 && n % 3 != 0 && n % 5 != 0) return false;
        while (true) {
           if(n / 2 * 2 != n) {
               if(n % 3 != 0 || n % 5 != 0) {
                   bool = false;
               }
               break;
           }
           if(n == 2) return true;
           n /= 2;
        }

        while (true) {
            if(n / 3 * 3 != n) {
                if(n % 2 != 0 || n % 5 != 0) {
                    bool = false;
                }
                break;
            }
            if(n == 3) return true;
            n /= 3;
        }

        while (true) {
            if(n / 5 * 5 != n) {
                if(n % 3 != 0 || n % 2 != 0) {
                    bool = false;
                }
                break;
            }
            if(n == 5) return true;
            n /= 5;
        }
        return bool;
    }

    /**
     * 3指针
     * @param n
     * @return
     */
    public static int nthUglyNumber1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1,p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2]*2, num3 = dp[p3]*3, num5 = dp[p5]*5;
            dp[i] = Math.min(Math.min(num2,num3),num5);
            p2 = dp[i] == num2 ? ++p2 : p2;
            p3 = dp[i] == num3 ? ++p3 : p3;
            p5 = dp[i] == num5 ? ++p5 : p5;
        }
        
        return dp[n];
    }
}

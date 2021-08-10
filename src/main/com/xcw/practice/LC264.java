package com.xcw.practice;

/**
 * @author wangxuechao
 * @date 2021-08-09
 */
public class LC264 {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber1(1));
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


    public static boolean isUgly(int m) {
        boolean bool = true;
        if(m % 2 != 0 && m % 3 != 0 && m % 5 != 0) return false;
        int tmp = m;
        while (true) {
           if(tmp / 2 * 2 != tmp) {
               if(tmp % 3 != 0 || tmp % 5 != 0) {
                   bool = false;
               }
               break;
           }
           if(tmp == 2) return true;
           tmp /= 2;
        }

        while (true) {
            if(tmp / 3 * 3 != tmp) {
                if(tmp % 2 != 0 || tmp % 5 != 0) {
                    bool = false;
                }
                break;
            }
            if(tmp == 3) return true;
            tmp /= 3;
        }

        while (true) {
            if(tmp / 5 * 5 != tmp) {
                if(tmp % 3 != 0 || tmp % 2 != 0) {
                    bool = false;
                }
                break;
            }
            if(tmp == 5) return true;
            tmp /= 5;
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

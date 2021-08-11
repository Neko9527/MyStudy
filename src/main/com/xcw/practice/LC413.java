package com.xcw.practice;


/**
 * @author wangxuechao
 * @date 2021-08-10
 */
public class LC413 {

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4,5,6}));
    }

    /**
     * 遍历数组，计算等差数列的长度，再更据长度算组成等差数列的数量
     * @param nums
     * @return
     */
    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int start = 0, ret = 0;
        int p1 = 0, p2 = 1;
        int step = nums[p2] - nums[p1];
        for (; p2 < nums.length; ) {
            if (step != nums[p2] - nums[p1]) {
                //计算个数
                int tmp = p1 - start + 1;
                ret += tmp > 2 ? (tmp - 2) * (tmp - 1) / 2 : 0;
                step = nums[p2] - nums[p1];
                start = p1;
            } else {
                if (p2 == nums.length - 1) {
                    int tmp = p2 - start + 1;
                    ret += tmp > 2 ? (tmp - 2) * (tmp - 1) / 2 : 0;
                }
            }
            p1++;
            p2++;
        }
        return ret;
    }

    public static int countArithmeticSlices(int n) {
        // (n - 2 )*( n - 1) / 2
        if (n < 3) return 0;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            count += n - i;
        }
        return count;
    }


    /**
     * 官解
     * https://leetcode-cn.com/problems/arithmetic-slices/solution/deng-chai-shu-lie-hua-fen-by-leetcode-so-g7os/
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices1(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int d = nums[0] - nums[1], t = 0;
        int ans = 0;
        // 因为等差数列的长度至少为 3，所以可以从 i=2 开始枚举
        for (int i = 2; i < n; ++i) {
            if (nums[i - 1] - nums[i] == d) {
                ++t;
            } else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }
}

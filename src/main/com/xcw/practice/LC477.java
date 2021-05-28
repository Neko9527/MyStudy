package com.xcw.practice;

/**
 * @author wangxuechao
 * @date 2021-05-28
 */
public class LC477 {

    public static void main(String[] args) {
        totalHammingDistance(new int[]{1, 2, 3, 4});
    }

    public static int totalHammingDistance(int[] nums) {

        /**
         * 在计算汉明距离时，我们考虑的是同一比特位上的值是否不同，而不同比特位之间是互不影响的。
         *
         * 对于数组 nums 中的某个元素 val，若其二进制的第 i位为 1，
         * 我们只需统计 nums 中有多少元素的第 i 位为 0，
         * 即计算出了 val 与其他元素在第 i 位上的汉明距离之和。
         *
         * 具体地，若长度为 n 的数组nums 的所有元素二进制的第 i 位共有 c 个 1，n−c 个 0，
         * 则些元素在二进制的第 i 位上的汉明距离之和为c*(n−c)
         */
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < 31; i++) {
            int c = 0;
            for (int num : nums) {
                c += (num >> i) & 1;
            }
            count += (n - c) * c;
        }
        return count;
    }


    /**
     * 暴力破解法，效率太差
     * @param nums
     * @return
     */
    public int totalHammingDistance1(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                count += LC461.hammingDistance1(nums[i],nums[j]);
            }
        }
        System.out.println(count);
        return count;
    }
}

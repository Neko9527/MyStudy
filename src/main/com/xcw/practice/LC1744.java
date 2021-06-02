package com.xcw.practice;

import java.util.Arrays;

/**
 * @author wangxuechao
 * @date 2021-06-01
 * @description can-you-eat-your-favorite-candy-on-your-favorite-day
 */
public class LC1744 {

    public static void main(String[] args) {
        test(new int[]{5, 2, 6, 4, 1}, new int[][]{{3, 1, 2}, {4, 10, 3}, {3, 10, 100}, {4, 10, 2}, {1, 3, 1}});
        canEat(new int[]{16, 38, 8, 41, 30, 31, 14, 45, 3, 2, 24, 23, 38, 30, 31, 17, 35, 4, 9, 42, 28, 18, 37, 18, 14, 46, 11, 13, 19, 3, 5, 39, 24, 48, 20, 29, 4, 19, 36, 11, 28, 49, 38, 16, 23, 24, 4, 22, 29, 35, 45, 38, 37, 40, 2, 37, 8, 41, 33, 8, 40, 27, 13, 4, 33, 5, 8, 14, 19, 35, 31, 8, 8},
                new int[][]{{35, 669, 5}, {72, 822, 74}, {47, 933, 94}, {62, 942, 85}, {42, 596, 11}, {56, 1066, 18}, {54, 571, 45}, {39, 890, 100}, {3, 175, 26}, {48, 1489, 37}, {40, 447, 52}, {30, 584, 7}, {26, 1486, 38}, {21, 1142, 21}, {9, 494, 96}, {56, 759, 81}, {13, 319, 16}, {20, 1406, 57}, {11, 1092, 19}, {24, 670, 67}, {38, 1702, 33}, {5, 676, 32}, {50, 1386, 77}, {36, 1551, 87}, {29, 1445, 13}, {58, 977, 13}, {7, 887, 64}, {37, 1396, 23}, {0, 765, 69}, {40, 1083, 86}, {43, 1054, 49}, {48, 690, 92}, {28, 1201, 56}, {47, 948, 43}, {57, 233, 25}, {32, 1293, 65}, {0, 1646, 34}, {43, 1467, 39}, {39, 484, 23}, {21, 1576, 69}, {12, 1222, 68}, {9, 457, 83}, {32, 65, 9}, {10, 1424, 42}, {35, 534, 3}, {23, 83, 22}, {33, 501, 33}, {25, 679, 51}, {2, 321, 42}, {1, 240, 68}, {7, 1297, 42}, {45, 480, 72}, {26, 1472, 9}, {6, 649, 90}, {26, 361, 57}, {49, 1592, 7}, {11, 158, 95}, {35, 448, 24}, {41, 1654, 10}, {61, 510, 43}, {31, 1230, 95}, {11, 1471, 12}, {37, 43, 84}, {56, 1147, 48}, {69, 1368, 65}, {22, 170, 24}, {56, 192, 80}, {34, 1207, 69}, {1, 1226, 22}, {37, 1633, 50}, {11, 98, 58}, {17, 125, 13}, {0, 1490, 5}, {37, 1732, 43}, {45, 793, 14}, {16, 578, 72}, {50, 241, 78}});
    }

    /**
     * 给你一个下标从 0 开始的正整数数组candiesCount，
     * 其中candiesCount[i]表示你拥有的第i类糖果的数目。同时给你一个二维数组queries，
     * 其中queries[i] = [favoriteTypei, favoriteDayi, dailyCapi]。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day
     *
     * @param candiesCount
     * @param queries
     * @return candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
     */
    public static boolean[] canEat(int[] candiesCount, int[][] queries) {
        //在吃到最喜欢的糖果之前要吃多少个其他的糖果
        long[] sum = new long[candiesCount.length];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + candiesCount[i - 1];
        }

        boolean[] ret = new boolean[queries.length];
        int i = 0;
        while (i < queries.length) {
            //假设天数为 n, 每天吃的最多糖数为m, 最喜欢的糖果数量为 f;
            int n = queries[i][1];
            int m = queries[i][2];
            int f = candiesCount[queries[i][0]];
            //前 n天最多吃的糖数,由于吃糖是从第0天开始
            long maxCount = (long) n * m;
            //前 n天最少吃的糖数 每天吃一块;
            long minCount = n;
            //在吃到最喜欢吃的糖之前要吃多少块糖
            //最喜欢的糖
            int type = queries[i][0];
            long targetCount = sum[type];
            //最少吃的糖数必须小于 (等于都不行) targetCount + f, 这样意味着第n天可以吃到一块自己喜欢的糖
            //前 n 天吃的糖数 必须要大于 targetCount - m , 这样才能保证第n天至少可以吃到自己喜欢吃的糖
            if (maxCount > (targetCount - m) && minCount < targetCount + f) {
                ret[i] = true;
            }
            i++;
            System.out.println(minCount + " " + maxCount + " " + targetCount);
        }
        System.out.println(Arrays.toString(ret));
        return ret;
    }


    public static void test(int[] candiesCount, int[][] queries) {
        boolean[] ret = new boolean[queries.length];
        int i = 0;
        while (i < queries.length) {
            //假设天数为 n, 每天吃的最多糖数为m, 最喜欢的糖果数量为 x;
            int n = queries[i][1];
            int m = queries[i][2];
            int f = candiesCount[queries[i][0]];
            //前 n天 (不包含n) 最多吃的糖数,由于吃糖是从第0天开始
            long maxCount = (long) n * m;
            //前 n天 (不包含n) 最少吃的糖数 每天吃一块;
            long minCount = n;
            //在吃到最喜欢吃的糖之前要吃多少块糖
            long targetCount = 0;
            //最喜欢的糖
            int type = queries[i][0];
            for (int j = 0; j < type; j++) {
                targetCount += candiesCount[j];
            }
            //最少吃的糖数必须小于 (等于都不行) targetCount + f, 这样意味着第n天可以吃到一块自己喜欢的糖
            long x = targetCount + f;
            //前 n 天吃的糖数 必须要大于
            if (maxCount > (targetCount - m) && minCount < x) {
                ret[i] = true;
            }
            i++;
            System.out.println(minCount + " " + maxCount + " " + targetCount);
        }
        System.out.println(Arrays.toString(ret));
    }
}

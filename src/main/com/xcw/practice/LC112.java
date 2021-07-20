package com.xcw.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wangxuechao
 * @date 2021-07-20
 */
public class LC112 {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        TreeNode n11 = new TreeNode(11);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n13 = new TreeNode(13);
        TreeNode n4r = new TreeNode(4);
        TreeNode n1 = new TreeNode(1);
        node.left = n4;
        node.right = n8;
        n4.left = n11;
        n11.left = n7;
        n11.right = n2;
        n8.left = n13;
        n8.right = n4r;
        n4r.right = n1;

        System.out.println(hasPathSum1(node, 22));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int sum = 0;
        Map<Boolean, Object> map = new HashMap<>();
        countSum(root, sum, targetSum, map);
        return map.containsKey(new Boolean(true));
    }

    public static void countSum(TreeNode root, int sum, int targetSum, Map<Boolean, Object> map) {

        if (root != null) {
            sum += root.val;
        }
        if (sum == targetSum && root.right == null && root.left == null) {
            map.put(new Boolean(true), new Object());
        }
        if (root.right != null) {
            countSum(root.right, sum, targetSum, map);
        }
        if (root.left != null) {
            countSum(root.left, sum, targetSum, map);
        }
    }


    public static boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        return hasPathSum1(root.right, targetSum - root.val)
                || hasPathSum1(root.left, targetSum - root.val);
    }

}

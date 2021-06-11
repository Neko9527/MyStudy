package com.xcw.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxuechao
 * @date 2021-04-27
 */
public class LC938 {

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3,null,null);
        TreeNode t7 = new TreeNode(7,null,null);
        TreeNode t5 = new TreeNode(5,t3,t7);
        TreeNode t18 = new TreeNode(18,null,null);
        TreeNode t15 = new TreeNode(15,null,t18);
        TreeNode t10 = new TreeNode(10,t5,t15);

//        t15.left = new TreeNode(13,null,null);
//        t3.left = new TreeNode(1,null,null);
//        t7.left = new TreeNode(6,null,null);
        System.out.println(rangeSumBST(t10,7,15));
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        List<TreeNode> trees = new ArrayList<>();
        trees.add(root);

        while (trees.size() != 0) {
            List<TreeNode> next = new ArrayList<>();

            for (int i = 0; i < trees.size();) {
                TreeNode node = trees.get(i);
                if (node.val <= high && node.val >= low) {
                    sum += node.val;
                }
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
                if (i == trees.size() - 1) {
                    i = 0;
                    trees = new ArrayList<>(next);
                    next.clear();
                }else {
                    i++;
                }
            }

        }
        return sum;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
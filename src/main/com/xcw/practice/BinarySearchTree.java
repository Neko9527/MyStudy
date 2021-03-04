package com.xcw.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxuechao
 * @version 1.0
 * 二叉搜索树 特点：任何根节点的值一定大于左节点且小于右节点
 * @since 2021-03-03
 */
public class BinarySearchTree {

    public BinarySearchTree parent;

    public BinarySearchTree left;

    public BinarySearchTree right;

    public Integer current;

    public BinarySearchTree(Integer current) {
        this(current, null);
    }

    public BinarySearchTree(Integer current, BinarySearchTree parent) {
        this.current = current;
        this.parent = parent;
    }

    /**
     * 插入一个值
     * @param value 要插入的值
     */
    public void insert(Integer value) {
        if (this.current == null) {
            this.current = value;
        } else {
            insert(this, value);
        }
    }

    public void insert(BinarySearchTree tree, Integer value) {
        if (value.intValue() == tree.current.intValue())
            return;
        if (value > tree.current) {
            if (tree.right == null)
                tree.right = new BinarySearchTree(value, tree);
            else {
                tree = tree.right;
                insert(tree, value);
            }
        } else {
            if (tree.left == null)
                tree.left = new BinarySearchTree(value, tree);
            else {
                tree = tree.left;
                insert(tree, value);
            }
        }
    }

    /**
     * 搜索某个值是否存在
     * @param tree 目标树
     * @param value 要搜索的值
     * @return BinarySearchTree
     */
    static BinarySearchTree search(BinarySearchTree tree, Integer value) {
        if(tree == null)
            throw new RuntimeException("二叉树为空");
        if (tree.current.intValue() == value.intValue())
            return tree;
        if (tree.current > value) {
            if (tree.left == null)
                return null;
            return search(tree.left, value);
        } else {
            if (tree.right == null)
                return null;
            return search(tree.right, value);
        }

    }

    /**
     * 删除某个节点
     * @param tree 目标树
     * @param value 要删除的值
     */
    static void delete(BinarySearchTree tree,Integer value) {
        tree = search(tree, value);
        if(tree == null)
            System.out.println("该元素在树中不存在");
        else{
            //将该节点的父节点的左子树指向该节点的右子树
            tree.parent.left = tree.right;
            //再将该节点的子树转移到最左节点下
            BinarySearchTree right = tree.right;
            if(right.left == null){
                right.left = tree.left;
                return;
            }
            BinarySearchTree left = right.left;
            while (left.left != null) {
                left = left.left;
            }
            left.left = tree.left;
            tree.left.parent = left;
        }
    }

    /**
     * 前序遍历
     * @param tree 目标树
     */
    static void frontTraversal(BinarySearchTree tree) {
        if(tree == null)
            return;
        System.out.print(tree.current + " ");
        if (tree.left != null) {
            frontTraversal(tree.left);
        }
        if(tree.right != null){
            frontTraversal(tree.right);
        }
    }

    //中序遍历
    static void midTraversal(BinarySearchTree tree) {
        if(tree == null)
            return;
        if(tree.left != null){
            midTraversal(tree.left);
        }
        System.out.print(tree.current + " ");
        if(tree.right != null) {
            midTraversal(tree.right);
        }
    }

    //后序遍历
    static void backTraversal(BinarySearchTree tree) {
        if(tree == null)
            return;
        if(tree.left != null){
            backTraversal(tree.left);
        }
        if(tree.right != null){
            backTraversal(tree.right);
        }
        System.out.print(tree.current + " ");
    }

    //层序遍历 BFS
    static void levelTraversal(BinarySearchTree tree) {
        if(tree == null)
            return;
        List<BinarySearchTree> trees = new ArrayList<>();
        trees.add(tree);
        levelTraversal(trees);
    }
    static void levelTraversal(List<BinarySearchTree> trees){
        List<BinarySearchTree> next = new ArrayList<>();
        for (int i = 0; i < trees.size(); i++) {
            BinarySearchTree tree = trees.get(i);
            System.out.println(tree.current);
            if(tree.left != null)
                next.add(tree.left);
            if(tree.right != null)
                next.add(tree.right);
        }
        if(next.size() > 0)
            levelTraversal(next);
    }

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree(10);
        tree.insert(3);
        tree.insert(1);
        tree.insert(8);
        tree.insert(7);
        tree.insert(9);
        tree.insert(6);
        tree.insert(15);
//        backTraversal(tree);
        levelTraversal(tree);
    }
}
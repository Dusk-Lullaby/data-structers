package com.Sonnet.Threaded;

public class ThreadedBinaryTree {
    private TreeNode root;
    private int count;

    public ThreadedBinaryTree() {}
    public ThreadedBinaryTree(TreeNode root) {
        this.root = root;
        this.count = 1;
    }

    /*
        功能： 插入
        参数： 父亲节点 左孩子 右孩子
        返回值： 无
     */
    public void insertTreeNode(TreeNode parent, TreeNode left, TreeNode right) {
        if (parent == null) return;
        if (left != null) {
            parent.left = left;
            this.count++;
        }
        if (right != null) {
            parent.right = right;
            this.count++;
        }
    }

    /*
        功能： 访问节点
        参数： 节点
        返回值： 无
     */
    public void visitTreeNode(TreeNode node) {
        if (node == null) return;
        System.out.print(node.data + "\t");
    }

    private TreeNode pre = null;
    private void inOrderTreeNode(TreeNode node) {
        //递归退出条件
        if (node == null) return;
        inOrderTreeNode(node.left);
        if (node.left == null) {
            node.left = pre;
            node.leftTag = true;
        }
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.rightTag = true;
        }
        pre = node;
        inOrderTreeNode(node.right);
    }

    /*
        功能： 线索化二叉树
        参数： 无
        返回值： 无
     */
    public void inOrderThreadingBinaryTree() {
        inOrderTreeNode(this.root);
    }

    /*
        功能： 中序遍历线索二叉树
        参数:  无
        返回值： 无
     */
    public void inOrderThreadedBinaryTree() {
        TreeNode node = this.root;
        while (node != null) {
            //一直往左, 直到左线索点
            while (!node.leftTag) {
                node = node.left;
            }
            //访问头节点
            visitTreeNode(node);
            //一路向右
            while (node.rightTag && node.right != null) {
                node = node.right;
                visitTreeNode(node);
            }
            //重置头节点
            node = node.right;
        }
        System.out.println();
    }

    private void freeTreeNode(TreeNode node) {
        if (node == null) return;
        if (!node.leftTag) {
            freeTreeNode(node.left);
        }
        if (!node.rightTag) {
            freeTreeNode(node.right);
        }
        node.left = null;
        node.right = null;
        this.count--;
    }

    /*
        功能： 释放线索二叉树
        参数: 无
        返回值： 无
     */
    public void releaseThreadedBinaryTree() {
        freeTreeNode(this.root);
        System.out.println("tree have " + this.count + " node");
        this.root = null;
    }
}

package com.Sonnet.Traversal;

import com.Sonnet.Tree.Element;
import com.Sonnet.Tree.TreeNode;
import org.w3c.dom.ls.LSOutput;

public class BinaryTree {
    private int num;
    private TreeNode root;
    public BinaryTree() {
        this.num = 0;
        this.root = null;
    }
    public BinaryTree(Element element) {
        this.num = 1;
        this.root = new TreeNode(element);
    }
    public BinaryTree(TreeNode node) {
        this.root = node;
        this.num = 1;
    }

    /*
        功能： 插入结点
        参数： 父亲结点 左孩子 右孩子
        返回值： 无
    */
    public void insertTreeNode(TreeNode parent, TreeNode left, TreeNode right) {
        if (parent != null) {
            if (left != null) {
                parent.left = left;
                this.num++;
            }
            if (right != null) {
                parent.right = right;
                this.num++;
            }
        }
    }

    /*
        功能： 打印结点数据
        参数： 结点
        返回值： 无
     */
    public void visitTreeNode(TreeNode node) {
        if (node != null) {
            System.out.print(node.element + " ");
        }
    }

    /*
        功能： 广度优先遍历
        参数： 无
        返回值： 无
     */
    private static final int MAX_QUEUE_SIZE = 10;
    public void levelOrderBinaryTree() {
        //创建队列
        TreeNode[] queue = new TreeNode[MAX_QUEUE_SIZE];
        int front = 0;
        int rear = -1;
        //预激活
        queue[0] = this.root;
        rear = 1;
        TreeNode node;
        System.out.println("levelOrder:");
        //当队列为空时，停止
        while (front != rear) {
            //出队
            node = queue[front];
            this.visitTreeNode(node);
            front = (front + 1) % MAX_QUEUE_SIZE;
            //入队
            if (node.left != null) {
                if ((rear + 1) % MAX_QUEUE_SIZE == front) {
                    System.out.println("overflow");
                    return;
                }
                queue[rear] = node.left;
                rear = (rear + 1) % MAX_QUEUE_SIZE;
            }
            if (node.right != null) {
                if ((rear + 1) % MAX_QUEUE_SIZE == front) {
                    System.out.println("overflow");
                    return;
                }
                queue[rear] = node.right;
                rear = (rear + 1) % MAX_QUEUE_SIZE;
            }
        }
        System.out.println();
    }

    private void preOrderTreeNode(TreeNode node) {
        if (node == null) return;
        this.visitTreeNode(node);
        preOrderTreeNode(node.left);
        preOrderTreeNode(node.right);
    }

    /*
        功能： 先序遍历
        参数： 无
        返回值： 无
     */
    public void preOrderBinaryTree() {
        System.out.println("preOrder:");
        this.preOrderTreeNode(this.root);
        System.out.println();
    }

    private void inOrderTreeNode(TreeNode node) {
        if (node == null) return;
        inOrderTreeNode(node.left);
        this.visitTreeNode(node);
        inOrderTreeNode(node.right);
    }

    /*
        功能： 中序遍历
        参数： 无
        返回值： 无
     */
    public void inOrderBinaryTree() {
        System.out.println("inOrder:");
        this.inOrderTreeNode(this.root);
        System.out.println();
    }

    private void postOrderTreeNode(TreeNode node) {
        if (node == null) return;
        postOrderTreeNode(node.left);
        postOrderTreeNode(node.right);
        this.visitTreeNode(node);
    }

    /*
        功能： 后序遍历
        参数： 无
        返回值： 无
     */
    public void postOrderBinaryTree() {
        System.out.println("postOrder:");
        this.postOrderTreeNode(this.root);
        System.out.println();
    }

    /*
        功能： 先序非递归
        参数： 无
        返回值： 无
     */
    private static final int MAX_STACK_SIZE = 10;
    public void preOrderBinaryTreeNoRecur() {
        //申请栈
        TreeNode[] stack = new TreeNode[MAX_STACK_SIZE];
        int top = -1;
        //预启动
        stack[++top] = this.root;
        System.out.println("preOrderNoRecur:");
        TreeNode node;
        while (top >= 0) {
            node = stack[top--];
            this.visitTreeNode(node);
            if (node.right != null) {
                stack[++top] = node.right;
            }
            if (node.left != null) {
                stack[++top] = node.left;
            }
        }
        System.out.println();
    }

    /*
        功能： 中序非递归
        参数： 无
        返回值： 无
     */
    public void inOrderBinaryTreeNoRecur() {
        //申请栈
        TreeNode[] stack = new TreeNode[MAX_STACK_SIZE];
        int top = -1;
        System.out.println("inOrderNoRecur:");
        TreeNode node = this.root;
        while (top >= 0 || node != null ) {
            if (node != null) {
                stack[++top] = node;
                node = node.left;
            } else {
                node = stack[top--];
                visitTreeNode(node);
                node = node.right;
            }
        }
        System.out.println();
    }

    private void releaseTreeNode(TreeNode node) {
        if (node == null) return;
        releaseTreeNode(node.left);
        releaseTreeNode(node.right);
        node = null;
        this.num--;
    }

    /*
        功能： 释放二叉树
        参数： 无
        返回值： 无
     */
    public void releaseBinaryTree() {
        releaseTreeNode(this.root);
        System.out.println("tree node have " + this.num + " node");
    }
}

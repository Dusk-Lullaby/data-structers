package com.Sonnet.AVLTree;

import com.Sonnet.element.Element;

public class TreeNode {
    private Element data;
    private TreeNode left;
    private TreeNode right;
    private int height;

    public Element getData() {
        return data;
    }

    public void setData(Element data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public TreeNode() {
        this.data = null;
        this.height = 0;
        this.right = null;
        this.left = null;
    }

    public TreeNode(Element data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", height=" + height +
                '}';
    }
}

package com.Sonnet.BinarySearchTree;

import com.Sonnet.element.Element;

public class TreeNode {
    private Element data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {};
    public TreeNode(Element data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Element getData() {
        return data;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setData(Element data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}

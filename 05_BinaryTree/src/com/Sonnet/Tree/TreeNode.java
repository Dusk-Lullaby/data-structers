package com.Sonnet.Tree;

//定义结点
public class TreeNode {
    public Element element;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {}
    public TreeNode(Element element) {
        this.element = element;
    }
    public TreeNode(Element element, TreeNode left, TreeNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}


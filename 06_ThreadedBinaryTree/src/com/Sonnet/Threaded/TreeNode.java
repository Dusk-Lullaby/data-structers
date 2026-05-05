package com.Sonnet.Threaded;

public class TreeNode {
    Element data;
    TreeNode left;
    TreeNode right;
    //false 表示left指向节点，true 表示线索化（前驱）
    boolean leftTag;
    //false 表示right指向节点，true 表示线索化（后继）
    boolean rightTag;

    public TreeNode() {}
    public TreeNode(Element data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.leftTag = false;
        this.rightTag = false;
    }
}

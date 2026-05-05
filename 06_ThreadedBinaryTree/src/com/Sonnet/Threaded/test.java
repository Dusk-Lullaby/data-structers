package com.Sonnet.Threaded;

public class test {
    public static void main(String[] args) {
        ThreadedBinaryTree tree = initThreadedBinaryTree();
        tree.inOrderThreadingBinaryTree();
        tree.inOrderThreadedBinaryTree();
        tree.releaseThreadedBinaryTree();
    }

    public static ThreadedBinaryTree initThreadedBinaryTree() {
        TreeNode nodeA = new TreeNode(new Element('A'));
        TreeNode nodeB = new TreeNode(new Element('B'));
        TreeNode nodeC = new TreeNode(new Element('C'));
        TreeNode nodeD = new TreeNode(new Element('D'));
        TreeNode nodeE = new TreeNode(new Element('E'));
        TreeNode nodeF = new TreeNode(new Element('F'));
        TreeNode nodeG = new TreeNode(new Element('G'));
        TreeNode nodeH = new TreeNode(new Element('H'));
        TreeNode nodeK = new TreeNode(new Element('K'));

        ThreadedBinaryTree tree = new ThreadedBinaryTree(nodeA);
        tree.insertTreeNode(nodeA, nodeB, nodeE);
        tree.insertTreeNode(nodeB, null, nodeC);
        tree.insertTreeNode(nodeC, null, null);
        tree.insertTreeNode(nodeC, nodeD, null);
        tree.insertTreeNode(nodeD, null, null);
        tree.insertTreeNode(nodeE, null, nodeF);
        tree.insertTreeNode(nodeF, nodeG, null);
        tree.insertTreeNode(nodeG, nodeH, nodeK);

        return tree;
    }
}

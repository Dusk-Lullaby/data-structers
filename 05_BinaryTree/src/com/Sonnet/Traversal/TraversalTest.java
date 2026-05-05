package com.Sonnet.Traversal;

import com.Sonnet.Tree.Element;
import com.Sonnet.Tree.TreeNode;

public class TraversalTest {
    public static void main(String[] args) {
        BinaryTree tree = initTreeNode();
        tree.levelOrderBinaryTree();
        tree.preOrderBinaryTreeNoRecur();
        tree.preOrderBinaryTree();
        tree.inOrderBinaryTreeNoRecur();
        tree.inOrderBinaryTree();
        tree.postOrderBinaryTree();
        tree.releaseBinaryTree();
    }

    public static BinaryTree initTreeNode() {
        TreeNode nodeA = new TreeNode(new Element('A'));
        TreeNode nodeB = new TreeNode(new Element('B'));
        TreeNode nodeC = new TreeNode(new Element('C'));
        TreeNode nodeD = new TreeNode(new Element('D'));
        TreeNode nodeE = new TreeNode(new Element('E'));
        TreeNode nodeF = new TreeNode(new Element('F'));
        TreeNode nodeG = new TreeNode(new Element('G'));
        TreeNode nodeH = new TreeNode(new Element('H'));
        TreeNode nodeK = new TreeNode(new Element('K'));

        BinaryTree tree = new BinaryTree(nodeA);
        tree.insertTreeNode(nodeA, nodeB, nodeE);
        tree.insertTreeNode(nodeB, null, nodeC);
        tree.insertTreeNode(nodeC, nodeD, null);
        tree.insertTreeNode(nodeE, null, nodeF);
        tree.insertTreeNode(nodeF, nodeG, null);
        tree.insertTreeNode(nodeG, nodeH, nodeK);

        return tree;
    }
}

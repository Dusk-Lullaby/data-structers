package com.Sonnet.BinarySearchTree;

import com.Sonnet.element.Element;

public class BinarySearchTree {
    private TreeNode root;
    private int count;

    public BinarySearchTree() {
        this.root = null;
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public TreeNode getRoot() {
        return root;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                ", count=" + count +
                '}';
    }

    /*插入节点*/
    private TreeNode insertNode(TreeNode node,  Element data) {
        if (node == null) {
            this.count++;
            return new TreeNode(data);
        }
        if (data.getData() < node.getData().getData()) {
            node.setLeft(insertNode(node.getLeft(), data));
        }
        else if (data.getData() > node.getData().getData()) {
            node.setRight(insertNode(node.getRight(), data));
        }

        return node;
    }

    /*
        功能： 递归插入
        参数： 节点数据
        返回值： 无
     */
    public void insertTreeNodeRecur(Element data) {
        this.root = insertNode(this.root, data);
    }

    /*释放节点*/
    private void releaseTreeNode(TreeNode node) {
        if (node == null) {
            return;
        }
        releaseTreeNode(node.getLeft());
        releaseTreeNode(node.getRight());

        node.setLeft(null);
        node.setRight(null);
        this.count--;
    }

    /*
        功能： 释放二叉搜索树
        参数： 无
        返回值： 无
     */
    public void releaseBinarySearchTree() {
        releaseTreeNode(this.root);
        this.root = null;
        System.out.println("this tree have " + this.count + " node");
    }

    /*中序遍历节点*/
    private void inOrderTreeNode(TreeNode node) {
        if (node == null) return;
        this.inOrderTreeNode(node.getLeft());
        this.visitTreeNode(node);
        this.inOrderTreeNode(node.getRight());
    }

    /*
        功能： 中序遍历
        参数： 无
        返回值: 无
     */
    public void inOrderBinarySearchTree() {
        inOrderTreeNode(this.root);
        System.out.println();
    }

    /*
        功能： 访问节点数据
        参数： 节点
        返回值： 无
     */
    public void visitTreeNode(TreeNode node) {
        if (node == null) return;
        System.out.print(node.getData() + "\t");
    }

    /*
        功能： 获取二叉搜索树高度
        参数： 根节点
        返回值： 高度
     */
    public int heightBinarySearchTree(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = this.heightBinarySearchTree(root.getLeft());
        int rightHeight = this.heightBinarySearchTree(root.getRight());

        if (leftHeight > rightHeight) {
            return ++leftHeight;
        } else {
            return ++rightHeight;
        }
    }

    /*
        功能： 搜索节点
        参数： 数据
        返回值： 节点
     */
    public TreeNode searchTreeNode(Element data) {
        TreeNode node = this.root;
        while (node != null) {
            if (data.getData() < node.getData().getData()) {
                node = node.getLeft();
            } else if (data.getData() > node.getData().getData()) {
                node = node.getRight();
            } else {
                return node;
            }
        }
        return null;
    }

    /*
        功能：非递归插入节点
        参数：节点数据
        返回值：无
     */
    public void insertTreeNodeNoRecur(Element data) {
        //辅助指针
        TreeNode pre = null;
        TreeNode cur = this.root;

        while (cur != null) {
            pre = cur;
            if (data.getData() < cur.getData().getData()) {
                cur = cur.getLeft();
            } else if (data.getData() > cur.getData().getData()) {
                cur = cur.getRight();
            //相等直接返回
            } else {
                return;
            }
        }

        //创建节点
        TreeNode node = new TreeNode(data);

        if (pre != null) {
            if (data.getData() < pre.getData().getData()) {
                pre.setLeft(node);
            } else {
                pre.setRight(node);
            }
            //当根节点为空时，pre和cur都为空
        } else {
            this.root = node;
        }
        this.count++;
    }

    /*
        功能：递归删除二叉搜索树节点
        参数：节点数据
        返回值：无
     */
    public void deleteBinarySearchTreeNodeRecur(Element data) {
        this.root = deleteTreeNodeRecur(this.root, data);
    }

    /*递归删除节点*/
    private TreeNode deleteTreeNodeRecur(TreeNode node, Element data) {
        //归
        if (node == null) return null;
        //递
        if (data.getData() < node.getData().getData()) {
            node.setLeft(deleteTreeNodeRecur(node.getLeft(), data));
        } else if (data.getData() > node.getData().getData()) {
            node.setRight(deleteTreeNodeRecur(node.getRight(), data));
        //相等，找到了需要删除的节点
        } else {
            //临时指针
            TreeNode tmp;
            //度为1或者0
            if (node.getLeft() == null) {
                tmp = node.getRight();
                //解除引用
                node.setRight(null);
                node.setData(null);
                this.count--;
                return tmp;
            }
            //度为1
            if (node.getRight() == null) {
                tmp = node.getLeft();
                //解除引用
                node.setLeft(null);
                node.setData(null);
                this.count--;
                return tmp;
            }

            //当左右孩子都非空，度为2，需要找到前驱或者后继进行替换
            //后继
//            tmp = miniValueTreeNode(node.getRight());
//            node.setData(tmp.getData());
//            node.setRight(deleteTreeNodeRecur(node.getRight(), tmp.getData()));
            //前驱
            tmp = maxiValueTreeNode(node.getLeft());
            node.setData(tmp.getData());
            node.setLeft(deleteTreeNodeRecur(node.getLeft(), tmp.getData()));

        }

        return node;
    }

    /*寻找后继节点*/
    private TreeNode miniValueTreeNode(TreeNode node) {
        while (node != null && node.getLeft() != null) {
            node = node.getLeft();
        }

        return node;
    }

    /*寻找前驱节点*/
    private TreeNode maxiValueTreeNode(TreeNode node) {
        while (node != null && node.getRight() != null) {
            node = node.getRight();
        }

        return node;
    }

    /*
        功能：非递归删除节点
        参数：节点数据
        返回值：无
     */
    public void deleteBinarySearchTreeNodeNoRecur(Element data) {
        //前置指针
        TreeNode pre = null;
        TreeNode node = this.root;

        while (node != null) {
            if (data.getData() < node.getData().getData()) {
                pre = node;
                node = node.getLeft();
            } else if (data.getData() > node.getData().getData()) {
                pre = node;
                node = node.getRight();
            //找到需要删除的节点
            } else {
                break;
            }
        }

        if (node == null) {
            System.out.println("no " + data.getData() + " Element");
            return;
        }

        //辅助指针
        TreeNode tmp;
        if (node.getLeft() == null) {
            tmp = node.getRight();
        } else if (node.getRight() == null) {
            tmp = node.getLeft();
        //度为2
        } else {
            //前驱
//            maxiDeleteTreeNodeNoRecur(node);
            //后继
            miniDeleteTreeNodeNoRecur(node);
            this.count--;
            return;
        }

        //根节点
        if (pre == null) {
            this.root = tmp;
        } else {
            if (node.getData().getData() < pre.getData().getData()) {
                pre.setLeft(tmp);
            } else {
                pre.setRight(tmp);
            }
        }
        //解除引用
        node.setRight(null);
        node.setLeft(null);
        node.setData(null);
        this.count--;
    }

    /*非递归删除节点（前驱）*/
    private static void maxiDeleteTreeNodeNoRecur(TreeNode node) {
        TreeNode pre = null;
        TreeNode maxi = node.getLeft();

        while (maxi.getRight() != null) {
            pre = maxi;
            maxi = maxi.getRight();
        }

        //node->left就是前驱节点
        if (pre == null) {
            node.setData(maxi.getData());
            node.setLeft(maxi.getLeft());
            //解除引用
            maxi.setRight(null);
            maxi.setLeft(null);
            maxi.setData(null);
        } else {
            node.setData(maxi.getData());
            pre.setRight(maxi.getLeft());
            //解除引用
            maxi.setLeft(null);
            maxi.setData(null);
            maxi.setRight(null);
        }
    }

    /*非递归删除节点（后继）*/
    private void miniDeleteTreeNodeNoRecur(TreeNode node) {
        TreeNode pre = null;
        TreeNode mini = node.getRight();

        while (mini.getRight() != null) {
            pre = mini;
            mini = mini.getRight();
        }

        //node->left就是前驱节点
        if (pre == null) {
            node.setData(mini.getData());
            node.setRight(mini.getRight());
        } else {
            node.setData(mini.getData());
            pre.setLeft(mini.getRight());
        }
        //解除引用
        mini.setData(null);
        mini.setRight(null);
        mini.setLeft(null);
    }
}

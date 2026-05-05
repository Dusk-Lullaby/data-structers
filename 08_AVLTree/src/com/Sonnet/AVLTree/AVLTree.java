package com.Sonnet.AVLTree;

import com.Sonnet.element.Element;

public class AVLTree {
    private TreeNode root;
    private int count;

    public AVLTree() {
        TreeNode root = null;
        this.count = 0;
    }

    public TreeNode getRoot() {
        return root;
    }

    public int getCount() {
        return count;
    }

    /*
            功能：释放平衡二叉树
            参数：无
            返回值：无
         */
    public void releaseAVLTree() {
        releaseTreeNode(this.root);
        System.out.println("release: tree have " + this.count + " node");
    }

    //释放节点
    private void releaseTreeNode(TreeNode node) {
        if (node == null) return;

        releaseTreeNode(node.getLeft());
        releaseTreeNode(node.getRight());

        node.setLeft(null);
        node.setRight(null);
        this.count--;
    }

    /*
        功能：访问节点数据
        参数：节点
        返回值：无
     */
    public void visitTreeNode(TreeNode node) {
        if (node == null) return;
        System.out.print(node + "\t");
    }

    /*
        功能：中序遍历
        参数：平衡二叉树根节点
        返回值：无
     */
    public void inOrderAVLTree(TreeNode node) {
        if (node == null) return;

        inOrderAVLTree(node.getLeft());
        visitTreeNode(node);
        inOrderAVLTree(node.getRight());
    }

    /*
        功能：获取高度
        参数：平衡二叉树节点
        返回值：高度
     */
    public int getHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());

        return leftHeight > rightHeight ? ++leftHeight : ++rightHeight;
    }

    /*
        功能：插入节点
        参数：节点数据
        返回值：无
     */
    public void insertAVLTreeNode(Element data) {
        this.root = insertTreeNode(this.root, data);
    }

    //插入节点
    private TreeNode insertTreeNode(TreeNode node, Element data) {
        if (node == null) {
            this.count++;
            return new TreeNode(data);
        }

        if (data.getData() < node.getData().getData()) {
            node.setLeft(insertTreeNode(node.getLeft(), data));
        } else if (data.getData() > node.getData().getData()) {
            node.setRight(insertTreeNode(node.getRight(), data));
        //相等
        } else {
            return null;
        }

        //计算高度
        node.setHeight(maxNum(h(node.getLeft()), h(node.getRight())) + 1);
        //获取平衡因子
        int balance = getBalance(node);

        //R
        if (balance < -1) {
            //L
           if (data.getData() < node.getRight().getData().getData()) {
                node.setRight(rightRotate(node.getRight()));
           }
           return leftRotate(node);
        //L
        } else if (balance > 1) {
           //R
           if (data.getData() > node.getLeft().getData().getData()) {
               node.setLeft(leftRotate(node.getLeft()));
           }
           return rightRotate(node);
        }

        return node;
    }

    //计算高度
    private int h(TreeNode node) {
        if (node == null) return 0;
        return node.getHeight();
    }

    //获取较大值
    private int maxNum(int a, int b) {
        return a > b ? a : b;
    }

    //获取平衡因子
    private int getBalance(TreeNode node) {
        return h(node.getLeft()) - h(node.getRight());
    }

    /*
                    p					p
                    |					|
                    y					x
                  /   \				  /   \
                x      ry			lx     y
              /    \			   /     /   \
            lx    rx					rx    ry
           /
    */
    //右旋，y是失衡节点
    private TreeNode rightRotate(TreeNode y) {
        //旋转
        TreeNode x = y.getLeft();
        y.setLeft(x.getRight());
        x.setRight(y);

        //更新高度
        y.setHeight(maxNum(h(y.getLeft()), h(y.getRight())));
        x.setHeight(maxNum(h(x.getLeft()), h(x.getRight())));

        return x;
    }

    /*
            p					p
            |					|
            x					y
          /   \				  /   \
         lx    y			 x    ry
             /   \		   /  \		\
            ly    ry	  lx  ly
                    \
    */
    //左旋，x是失衡节点
    private TreeNode leftRotate(TreeNode x) {
        //旋转
        TreeNode y = x.getRight();
        x.setRight(y.getLeft());
        y.setLeft(x);

        //更新高度
        x.setHeight(maxNum(h(x.getLeft()), h(x.getRight())));
        y.setHeight(maxNum(h(y.getLeft()), h(y.getRight())));

        return y;
    }

    /*
        功能：删除平衡二叉树节点
        参数：节点数据
        返回值：无
     */
    public void deleteAVLTreeNode(Element data) {
        this.root = deleteTreeNode(this.root, data);
    }

    //删除节点
    private TreeNode deleteTreeNode(TreeNode node,  Element data) {
        if (node == null) return null;

        //临时节点
        TreeNode tmp;

        if (data.getData() < node.getData().getData()) {
            node.setLeft(deleteTreeNode(node.getLeft(), data));
        } else if (data.getData() > node.getData().getData()) {
            node.setRight(deleteTreeNode(node.getRight(), data));
        //找到需要删除的节点
        } else {
            //度为1或者0
            if (node.getLeft() == null || node.getRight() == null) {
                tmp = node.getLeft() == null ? node.getRight() : node.getLeft();

                //度为0
                if (tmp == null) {
                    this.count--;
                    return null;
                //度为1
                } else {
                    node.setRight(null);
                    node.setLeft(null);
                    node.setData(null);
                    node.setHeight(0);
                    this.count--;
                    return tmp;
                }
            }
            //度为2
            else {
                //找到前驱节点
                tmp = node.getLeft();
                while (tmp.getRight() != null) {
                    tmp = tmp.getRight();
                }

                //替换
                node.setData(tmp.getData());
                node.setLeft(deleteTreeNode(node.getLeft(), tmp.getData()));
            }
        }

        //计算高度
        node.setHeight(maxNum(h(node.getLeft()), h(node.getRight())) + 1);
        //计算平衡因子
        int balance = getBalance(node);

        //R
        if (balance < -1) {
            //L
            if (getBalance(node.getRight()) > 0) {
                node.setRight(rightRotate(node.getRight()));
            }
           node = leftRotate(node);
        //L
        } else if (balance > 1) {
           //R
           if (getBalance(node.getLeft()) < 0) {
               node.setLeft(leftRotate(node.getLeft()));
           }
           node = rightRotate(node);
        }

        return node;
    }

}

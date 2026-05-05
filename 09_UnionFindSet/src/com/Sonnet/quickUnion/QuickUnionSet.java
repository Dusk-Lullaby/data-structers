package com.Sonnet.quickUnion;

import com.Sonnet.element.Element;

public class QuickUnionSet {
    private Element[] data;
    private int[] parent;   //存放对应父节点的编号
    private int[] size;     //存放对应元素作为根节点时，表示元素的个数

    public QuickUnionSet(int n) {
        this.data = new Element[n];
        this.parent = new int[n];
        this.size = new int[n];
    }

    /*
        功能：释放并查集
        参数：无
        返回值：无
     */
    public void releaseQuickUnionSet() {
        this.data = null;
        this.size = null;
        this.parent = null;
    }

    /*
        功能：初始化
        参数：数据数组
        返回值：无
     */
    public void initQuickUnionSet(Element[] data) {
        for (int i = 0; i < data.length; i++) {
            this.data[i] = data[i];
            this.size[i] = 1;
            this.parent[i] = i;
        }
    }

    /*
        功能：查找
        参数：元素a 元素b
        返回值：成功true 失败false
     */
    public boolean findQuickUnionSet(Element a, Element b) {
        int aRoot = findRoot(a);
        int bRoot = findRoot(b);
        if (aRoot == -1 || bRoot == -1) return false;
        return aRoot == bRoot;
    }

    /*
    //查找根
    private int findRoot(Element e) {
        int index = findIndex(e);
        if (index == -1) return index;
        //当父节点是自己时则为根节点
        while(this.parent[index] != index) {
            index = this.parent[index];
        }
        return index;
    }

     */

    //路径压缩
    //查找根
    private int findRoot(Element e) {
        return find(findIndex(e));
    }

    private int find(int curIndex) {
        if (this.parent[curIndex] == curIndex) {
            return curIndex;
        }
        // 递归逻辑：
        // 1. 先找到 parent[p] 的根节点
        // 2. 路径压缩：将 p 的父节点直接更新为这个根节点
        parent[curIndex] = find(parent[curIndex]);

        return parent[curIndex];
    }

    //查找索引
    private int findIndex(Element e) {
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i].equals(e))
                return i;
        }
        return -1;
    }

    /*
        功能：合并
        参数：元素a 元素b
        返回值：无
     */
    public void unionQuickUnionSet(Element a, Element b) {
        int aRoot = findRoot(a);
        int bRoot = findRoot(b);
        if (aRoot == -1 || bRoot == -1) return;
        if (this.size[aRoot] > this.size[bRoot]) {
            this.parent[bRoot] = this.parent[aRoot];
            this.size[aRoot] += this.size[bRoot];
        } else {
            this.parent[aRoot] = this.parent[bRoot];
            this.size[bRoot] += this.size[aRoot];
        }
    }
}

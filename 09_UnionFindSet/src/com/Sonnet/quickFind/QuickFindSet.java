package com.Sonnet.quickFind;

import com.Sonnet.element.Element;

public class QuickFindSet {
    private Element[] data;
    private int n;
    private int[] groupID;

    public QuickFindSet(int n) {
        this.data = new Element[n];
        this.n = n;
        this.groupID = new int[n];
    }

    /*
        功能：释放并查集
        参数：无
        返回值：无
     */
    public void releaseQuickFindSet() {
        this.data = null;
        this.n = 0;
        this.groupID = null;
    }

    /*
        功能：初始化并查集
        参数：元素数组
        返回值：无
     */
    public void initQuickFindSet(Element[] data) {
        for (int i = 0; i < data.length; i++) {
            this.data[i] = data[i];
            this.groupID[i] = data[i].element;
        }
    }

    /*
        功能：查找两个元素是否在同一组
        参数：元素a 元素b
        返回值：成功true 失败false
     */

    public boolean findSetQuickFind(Element a, Element b) {
        int aIndex = findIndex(a);
        int bIndex = findIndex(b);
        if (aIndex == -1 || bIndex == -1) return false;
        return this.groupID[aIndex] == this.groupID[bIndex];
    }

    //查找索引
    private int findIndex(Element e) {
        for (int i = 0; i < this.n; i++) {
            if (this.data[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    /*
        功能：合并
        参数：元素a 元素b
        返回值：无
     */
    public void unionQuickFindSet(Element a, Element b) {
        int aIndex = findIndex(a);
        int bIndex = findIndex(b);
        if (aIndex == -1 || bIndex == -1) return;
        //备份
        int gID = this.groupID[bIndex];
        for (int i = 0; i < this.n; i++) {
            if (this.groupID[i] == gID)
                this.groupID[i] = this.groupID[aIndex];
        }
    }
}

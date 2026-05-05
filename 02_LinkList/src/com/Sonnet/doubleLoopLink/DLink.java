package com.Sonnet.doubleLoopLink;

public class DLink {

    //节点结构申明
    private static class DNode {
        Element val;
        DNode next;
        DNode prev;

        public DNode() {}
        public DNode(Element val) {
            this.val = val;
        }
    }

    //头节点，不需要记录数据
    DNode head;

    public DLink() {
        this.head = new DNode();
        this.head.next = this.head;
        this.head.prev = this.head;
    }

    /*
        功能： 插入
        参数： 前驱节点 需要插入的节点 后继节点
        返回值： 无
     */
    private void addDNode(DNode prev, DNode newDNode, DNode next) {
        next.prev = newDNode;
        newDNode.next = next;
        newDNode.prev = prev;
        prev.next = newDNode;
    }

    /*
        功能： 头插
        参数： 需要插入的元素
        返回值: 无
     */
    public void insertDLinkHeader(Element val) {
        //创建节点
        DNode newDNode = new DNode(val);
        //插入
        addDNode(this.head, newDNode, this.head.next);
    }

    /*
        功能： 尾插
        参数： 需要插入的元素
        返回值： 无
     */
    public void insertDLinkRear(Element val) {
        //创建节点
        DNode newDNode = new DNode(val);
        //插入
        addDNode(this.head.prev, newDNode, this.head);
    }

    /*
        功能： 遍历打印
        参数： 无
        返回值： 无
     */
    void showDLink() {
        DNode p = this.head.next;
        int cnt = 0;
        while (p != this.head) {
            System.out.print(p.val + " ");
            p = p.next;
            cnt++;
        }
        System.out.println();
        System.out.println("link have " + cnt + " node");
    }

    /*
        功能： 删除
        参数： 前驱节点 后继节点
        返回值： 无
     */
    private void deleteDNode(DNode prev, DNode next) {
        prev.next = next;
        next.prev = prev;
    }

    /*
        功能： 删除单个元素
        参数： 需要删除的元素
        返回值： 无
     */
    public void deleteDLinkElement(Element val) {
        //辅助指针p
        DNode p = this.head.next;
        //查找
        while (p != this.head && p.equals(val)) {
            p = p.next;
        }
        //查找失败
        if (p == this.head) {
            System.out.println("not found value");
            return;
        }
        //删除
        deleteDNode(p.prev, p.next);
        p.next = null;
        p.prev = null;
        p.val = null;
    }

    /*
        功能： 删除全部元素
        参数： 无
        返回值： 无
     */
    public void deleteALLDLink() {
        //辅助指针p
        DNode p = this.head.next;
        while (p != this.head) {
            deleteDNode(this.head, p.next);
            p.next = null;
            p.val = null;
            p.prev = null;
            p = this.head.next;
        }
    }
}

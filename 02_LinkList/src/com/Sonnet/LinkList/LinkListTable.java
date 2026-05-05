package com.Sonnet.LinkList;

public class LinkListTable {

    //节点结构
    private static class Node {
        Element value;
        Node next;

        public Node(Element value) {
            this.value = value;
            this.next = null;
        }

        public Node(Element value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(){}
    }

    int count;
    Node head;

    public LinkListTable() {
        this.head = new Node();
        this.head.next = null;
        this.count = 0;
    }


    /*
        功能： 头插
        参数： 需要插入的元素
        返回值： 成功true 失败false
     */
    public boolean insertLinkListHead(Element value) {
        if (value == null) return false;
        //p为前驱节点
        Node p = this.head;
        //创建新节点
        Node newNode = new Node(value, p.next);
        //处理老节点
        p.next = newNode;
        this.count++;

        return true;
    }

    /*
        功能： 打印链表中的元素
        参数： 无
        返回值： 无
     */
    public void showLinkList() {
        System.out.println("LinkList have " + this.count + " node");
        //辅助指针p
        Node p = this.head.next;
        while (p != null) {
            System.out.print(p.value + " ");
            p = p.next;
        }
        System.out.println();
    }

    /*
        功能： 删去链表中的元素
        参数： 需要删去的元素
        返回值： 成功true 失败false
     */
    public boolean deleteLinkListElement(Element value) {
        //创建前驱指针p
        Node p = this.head;
        //寻找value
        //重写equals方法
        while(p.next != null && !p.next.value.equals(value)) {
            p = p.next;
        }
        //没找到value
        if (p.next == null) {
            System.out.println("not found value");
            return false;
        }
        //删除
        Node tmp = p.next;
        p.next = tmp.next;
        //清理
        tmp.next = null;
        tmp.value = null;
        this.count--;

        return true;
    }

    /*
        功能： 任意位置插入元素
        参数： 需要插入的索引
        返回值： 成功true 失败false
     */
    public boolean insertLinkListPos(int pos, Element value) {
        //索引合法性
        if (pos < 0 || pos > this.count) {
            System.out.println("not found index");
            return false;
        }
        //寻找前驱节点
        int index = 0;
        Node p = this.head;
        while (p != null && index != pos -1) {
            p = p.next;
            index++;
        }
        if (p == null) return false;
        //插入
        Node newNode = new Node(value, p.next);
        p.next = newNode;
        this.count++;

        return true;
    }

    /*
        功能： 释放链表
        参数： 无
        返回值： 无
     */
    public void releaseLinkList() {
        //创建前置指针
        Node p = this.head;
        //创建临时指针
        Node tmp;
        while (p.next != null) {
            tmp = p.next;
            p.next = tmp.next;
            tmp.next = null;
            tmp.value = null;
            this.count--;
        }
        System.out.println("LinkList have " + this.count + " node");
        //释放表头
        this.head.value = null;
        this.head.next = null;
        this.count = 0;
    }
}

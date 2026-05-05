package com.Sonnet.LinkStack;

public class LinkStack {

    //节点结构
    private class Node {
        Element element;
        Node next;

        public Node() {};
        public Node(Element element) {
            this.element = element;
        }
    }

    private int count;
    private Node top;

    public LinkStack() {
        this.count = 0;
        this.top = null;
    }

    /*
        功能： 压栈
        参数： 需要压入的元素
        返回值： 成功true 失败false
     */
    public boolean pushLinkStack(Element element) {
        if (element == null) {
            return false;
        }

        //创建节点
        Node node = new Node(element);

        //push
        node.next = this.top;
        this.top = node;
        this.count++;

        return true;
    }

    /*
        功能： 弹栈
        参数： 无
        返回值： 成功true 失败false
     */
    public boolean popLinkStack() {
        //判断链栈为空
        if (this.count <= 0) {
            System.out.println("underFlow");
            return false;
        }

        //pop
        Node tmp = this.top;
        this.top = this.top.next;
        this.count--;
        //释放节点
        tmp.element = null;
        tmp.next = null;

        return true;
    }

    /*
    功能： 弹栈
    参数： 无
    返回值： 出栈的元素
 */
    public Element popLinkStackElement() {
        //判断链栈为空
        if (this.count <= 0) {
            System.out.println("underFlow");
            return null;
        }

        //pop
        Node tmp = this.top;
        this.top = this.top.next;
        this.count--;
        //释放
        Element e = tmp.element;
        tmp.element = null;
        tmp.next = null;

        return e;
    }

    /*
        功能： 释放链栈
        参数： 无
        返回值： 无
     */
    public void releaseLinkStack() {
        //临时指针tmp
        Node tmp;
        while (this.top != null) {
            tmp = this.top;
            this.top = this.top.next;
            //释放节点
            tmp.element = null;
            tmp.next = null;
        }
    }

    /*
        功能： 获取栈顶元素
        参数： 无
        返回值： 无
     */
    public Element getElement() {
        return this.top.element;
    }
}

package com.Sonnet.LinkQueue;

import com.Sonnet.Tree.Element;

public class LinkQueue {
    //节点结构
    private class Node {
        Element element;
        Node next;

        public Node() {}
        public Node(Element element) {
            this.element = element;
        }
        public Node(Element element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    int count;
    Node front;
    Node rear;

    public LinkQueue() {
        this.count = 0;
        this.front = null;
        this.rear = null;
    }

    /*
        功能： 入队
        参数： 需要入队的元素
        返回值： 成功true 失败false
     */
    public boolean enLinkQueue(Element element) {
        if (element == null) {
            return false;
        }
        //创建新节点
        Node node = new Node(element, null);
        //第一次入队
        if (this.front == null) {
            this.front = node;
            this.rear = node;
        } else {
            this.rear.next = node;
            this.rear = node;
        }
        this.count++;

        return true;
    }

    /*
        功能： 出队
        参数： 无
        返回值： 出队的元素
     */
    public Element deLinkQueue() {
        //空
        if (this.front == null) {
            System.out.println("empty");
            return null;
        }
        //临时保存
        Element tmp = this.front.element;
        Node oldNode = this.front;
        //出队
        this.front = oldNode.next;
        this.count--;
        oldNode.element = null;
        oldNode.next = null;
        // 最后一个元素出队
        if (this.front == null) {
            this.rear = null;
        }

        return tmp;
    }

    /*
        功能： 清理队列
        参数： 无
        返回值： 无
     */
    public void clearLinkQueue() {
        //临时指针
        Node tmp;
        while (this.front != null) {
            tmp = this.front;
            this.front = tmp.next;
            this.count--;
            tmp.next = null;
            tmp.element = null;
        }
        this.rear = null;
    }
}

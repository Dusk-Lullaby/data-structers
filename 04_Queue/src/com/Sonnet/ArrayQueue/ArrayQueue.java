package com.Sonnet.ArrayQueue;

import com.Sonnet.Tree.Element;

public class ArrayQueue {
    //最大值
    public static final int MAXSIZE = 5;
    private Element[] data;
    private int front;
    private int rear;

    public ArrayQueue() {
        this.data = new Element[MAXSIZE];
        this.front = 0;
        this.rear = 0;
    }

    /*
        功能： 入队
        参数： 需要入队的元素
        返回值： 成功true 失败false
     */
    public boolean enArrayQueue(Element element) {
        //判断队列是否为满
        if ((this.rear + 1) % MAXSIZE == this.front) {
            System.out.println("full");
            return false;
        }
        //入队
        //先入队再后移
        this.data[this.rear] = element;
        this.rear = (this.rear + 1) % MAXSIZE;

        return true;
    }

    /*
        功能： 出队
        参数： 无
        返回值： 出队的元素
     */
    public Element deArrayQueue() {
        //判断为空
        if (this.rear == this.front) {
            System.out.println("empty");
            return null;
        }
        //出队
        //先出队再后移
        Element tmp = this.data[this.front];
        this.front = (this.front + 1) % MAXSIZE;

        return tmp;
    }
}

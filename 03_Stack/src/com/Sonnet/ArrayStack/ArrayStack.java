package com.Sonnet.ArrayStack;

public class ArrayStack {
    //常量
    public static final int MAXSIZE = 5;

    private Element[] data;
    private int top;

    public ArrayStack() {
        this.data = new Element[MAXSIZE];
        this.top = -1;
    }

    /*
        功能： 压栈
        参数： 需要压栈的元素
        返回值： true成功 失败false
     */
    public boolean pushArrayStack(Element e) {
        //overFlow
        if (this.top >= MAXSIZE - 1) {
            System.out.println("overFlow");
            return false;
        }

        //push
        this.data[++this.top] = e;

        return true;
    }

    /*
        功能:  出栈
        参数： 无
        返回值：成功true 失败false
     */
    public boolean popArrayStack() {
        //underFlow
        if (this.top < 0) {
            System.out.println("underFlow");
            return false;
        }

        //pop
        this.top--;

        return true;
    }
}

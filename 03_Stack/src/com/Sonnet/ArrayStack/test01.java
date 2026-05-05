package com.Sonnet.ArrayStack;

public class test01 {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        ArrayStack arrayStack = new ArrayStack();
        for (int i = 0; i < 6; i++) {
            arrayStack.pushArrayStack(new Element(i));
        }
        for (int i = 0; i < 6; i++) {
            arrayStack.popArrayStack();
        }
    }
}

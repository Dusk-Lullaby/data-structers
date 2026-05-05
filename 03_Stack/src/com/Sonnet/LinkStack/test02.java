package com.Sonnet.LinkStack;

public class test02 {
    public static void main(String[] args) {
        test2();
    }

    public static void test2() {
        LinkStack linkStack = new LinkStack();
        linkStack.pushLinkStack(new Element(82));
        System.out.println(linkStack.getElement());
        linkStack.popLinkStack();
        linkStack.popLinkStack();
    }
}

package com.Sonnet.doubleLoopLink;

public class Test {
    public static void main(String[] args) {
        testDoubleLoopLink();
    }

    public static void testDoubleLoopLink() {
        DLink dLink = new DLink();
        for (int i = 0; i < 5; i++) {
            dLink.insertDLinkHeader(new Element(i + 100));
            dLink.insertDLinkRear(new Element(i + 50));
        }
        dLink.showDLink();
        System.out.println("---------------");
        dLink.deleteDLinkElement(new Element(50));
        dLink.deleteDLinkElement(new Element(104));
        dLink.showDLink();
        System.out.println("---------------");
        dLink.deleteALLDLink();
        dLink.showDLink();
    }
}

package com.Sonnet.LinkQueue;

import com.Sonnet.Tree.Element;

public class LinkTest {
    public static void main(String[] args) {
        test02();
    }

    public static void test02() {
        LinkQueue queue = new LinkQueue();
        for (int i = 0; i < 5; i++) {
            queue.enLinkQueue(new Element(i + 100));
        }
        Element e = new Element(82);
        while (e != null) {
            e = queue.deLinkQueue();
            System.out.print(e + " ");
        }
        queue.clearLinkQueue();
    }
}

package com.Sonnet.ArrayQueue;

import com.Sonnet.Tree.Element;

public class ArrayTest {
    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        ArrayQueue queue = new ArrayQueue();
        for (int i = 0; i < 5; i++) {
            queue.enArrayQueue(new Element(i + 100));
        }
        while (true) {
            Element e = queue.deArrayQueue();
            if (e == null) {
                break;
            }
            else {
                System.out.print(e + " ");
            }
        }
    }
}

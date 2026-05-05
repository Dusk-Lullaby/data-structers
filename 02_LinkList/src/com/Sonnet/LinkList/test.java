package com.Sonnet.LinkList;

public class test {
    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        LinkListTable link_table = new LinkListTable();
        for (int i = 0; i < 10; i++) {
            link_table.insertLinkListHead(new Element(100 + i));
        }
        link_table.showLinkList();
        System.out.println("---------------");
        link_table.deleteLinkListElement(new Element(109));
        link_table.deleteLinkListElement(new Element(100));
        link_table.showLinkList();
        System.out.println("-----------------");
    }
}

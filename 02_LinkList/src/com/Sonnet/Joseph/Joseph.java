package com.Sonnet.Joseph;

public class Joseph {

    //节点结构
    static class Node {
        int val;
        Node next;

        public Node() {};
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    Node head;
    Node tail;

    public Joseph(int number){
        for (int i = 1; i <= number; i++) {
            Node node = new Node(i);
            if (head == null) {
                this.head = node;
                this.tail = node;
            }
            else {
                this.tail.next = node;
                this.tail = node;
            }
            this.tail.next = head;
        }
    }

    public void showJoseph() {
        Node p = this.head;
        do {
            System.out.print(p.val + " ");
            p = p.next;
        } while (p != head);
        System.out.println();
    }

    public void startJoseph(int kill) {
        Node cur = this.head;
        Node pre = this.tail;
        //仅剩一人存活
        while (cur.next != cur) {
            //报数
            for (int i = 1; i < kill; i++) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = cur.next;
            cur.next = null;
            cur = pre.next;
        }
        System.out.println(cur.val + " is winner");
    }

}

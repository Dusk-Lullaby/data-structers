package com.sonnet.edge_set;

import com.Sonnet.matrix_graph.MatrixGraph;

public class EdgeSet {
    private int head;   // 头
    private int tail;   // 尾
    private int weight; // 权值

    public EdgeSet(int head, int tail, int weight) {
        this.head = head;
        this.tail = tail;
        this.weight = weight;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EdgeSet{" +
                "head=" + head +
                ", tail=" + tail +
                ", weight=" + weight +
                '}' + "\n";
    }
}

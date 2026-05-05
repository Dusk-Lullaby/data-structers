package com.Sonnt.cross_link_graph;

import org.w3c.dom.html.HTMLParagraphElement;

public class CrossLinkGraph<T> {

    // 弧结构
    private static class ArcBox {
        int head;               // 弧头
        int tail;               // 弧尾
        int weight;             // 权重
        ArcBox headNext;        // 下一个弧头
        ArcBox tailNext;        // 下一个弧尾

        public ArcBox(int head, int tail, int weight) {
            this.head = head;
            this.tail = tail;
            this.weight = weight;
        }
    }

    // 顶点结构
    private static class ArcVertex<T> {
        int number;         // 位置
        ArcBox firstIn;     // 入度
        ArcBox firstOut;    // 出度
        T show;             // 顶点数据

        public ArcVertex(int number, T show) {
            this.number = number;
            this.firstIn = null;
            this.firstOut = null;
            this.show = show;
        }
    }

    private int vertxNum;           // 顶点数量
    private int edgeNum;            // 弧的数量
    private ArcVertex[] vertices;   // 顶点数组

    public CrossLinkGraph(int vertxNum) {
        this.vertxNum = vertxNum;
        this.edgeNum = 0;
        this.vertices = new ArcVertex[vertxNum];
    }

    /*
        功能：初始化
        参数：顶点数组数据
        返回值：无
     */
    public void initCrossGraph(T[] names) {
        for (int i = 0; i < this.vertxNum; i++) {
            this.vertices[i] = new ArcVertex(i, names[i]);
        }
    }

    /*
        功能：添加边
        参数：弧头 弧尾 权重
        返回值：无
     */
    public void addArcBox(int head, int tail, int weight) {
        ArcBox box = new ArcBox(head, tail, weight);
        box.headNext = this.vertices[head].firstIn;
        this.vertices[head].firstIn = box;
        box.tailNext = this.vertices[tail].firstOut;
        this.vertices[tail].firstOut = box;

        this.edgeNum++;
    }

    /*
        功能：计算出度
        参数：顶点位置
        返回值：出度
     */
    public int outDegreeVertex(int num) {
        int count = 0;
        ArcBox box = this.vertices[num].firstOut;
        while (box != null) {
            box = box.tailNext;
            count++;
        }

        return count;
    }

    /*
        功能：计算入度
        参数：顶点位置
        返回值：出度
     */
    public int inDegreeVertex(int num) {
        int count = 0;
        ArcBox box = this.vertices[num].firstIn;
        while (box != null) {
            box = box.headNext;
            count++;
        }

        return count;
    }

    /*
        功能：释放
        参数：无
        返回值：无
     */
    public void releaseCrossGraph() {
        for (int i = 0; i < this.vertxNum; i++) {
            this.vertices[i] = null;
        }

        this.vertices = null;
        this.edgeNum = 0;
        this.vertxNum = 0;
    }

    public int getEdgeNum() {
        return edgeNum;
    }
}

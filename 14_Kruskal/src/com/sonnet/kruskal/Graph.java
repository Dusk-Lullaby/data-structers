package com.sonnet.kruskal;

import com.Sonnet.matrix_graph.MatrixGraph;

import java.util.Arrays;

public class Graph<T> {
    // 边集结构
    public static class EdgeSet {
        private int head;       // 头
        private int tail;       // 尾
        private int weight;     // 权重

        public EdgeSet(int head, int tail, int weight) {
            this.head = head;
            this.tail = tail;
            this.weight = weight;
        }

        public int getHead() {
            return head;
        }

        public int getTail() {
            return tail;
        }

        public int getWeight() {
            return weight;
        }
    }

    // 使用邻接矩阵来表示无向图，再从邻接矩阵中初始化边集数组
    private EdgeSet[] edges;
    private int edgeNum;
    private int vertexNum;

    // 使用邻接矩阵来表示无向图，再从邻接矩阵中初始化边集数组
    public Graph(MatrixGraph<T> matrixGraph) {
        this.edgeNum = matrixGraph.getEdgeNum();
        this.vertexNum = matrixGraph.getVertexNum();
        this.edges = new EdgeSet[this.edgeNum];
        MatrixGraph.MatrixEdge[][] matrixEdges = matrixGraph.getEdges();

        int cnt = 0;
        for (int i = 0; i < this.vertexNum; i++) {
            for (int j = i; j < vertexNum; j++) {
                if (matrixEdges[i][j].getMatrixEdge() > 0) {
                    this.edges[cnt++] = new EdgeSet(i, j , matrixEdges[i][j].getMatrixEdge());
                }
            }
        }
    }

    /*
        功能：排序
        参数：无
        返回值：无
     */
    public void sortEdgeSet() {
        for (int i = 0; i < this.edgeNum; i++) {
            for (int j = i; j < this.edgeNum; j++) {
                if (edges[i].weight > edges[j].weight) {
                    EdgeSet tmp = edges[i];
                    edges[i] = edges[j];
                    edges[j] = tmp;
                }
            }
        }
    }

    /*
        功能：kruskal
        参数：最短路径数组
        返回值：最短路径
     */
    public int kruskalEdgeSet(EdgeSet[] result) {
        int[] uSet = new int[this.vertexNum];
        for (int i = 0; i < this.vertexNum; i++) {
            uSet[i] = i;
        }

        int count = 0;
        int sum = 0;
        for (int i = 0; i < this.edgeNum; i++) {
            int a = findRoot(uSet, this.edges[i].head);
            int b = findRoot(uSet, this.edges[i].tail);
            if (a != b) {
                uSet[a] = b;
                result[count] = new EdgeSet(this.edges[i].head, this.edges[i].tail, this.edges[i].weight);
                count++;
                sum += this.edges[i].weight;
                if (count == this.vertexNum - 1) break;
            }
        }

        return sum;
    }

    /*
        功能：压缩路径寻找根节点
        参数：并查集 需要查找的节点
        返回值：根节点
     */
    private int findRoot(int[] uSet, int a) {
        // 当父亲节点为自己时，则为根节点
        if (uSet[a] != a) {
            uSet[a] = findRoot(uSet, uSet[a]);
        }

        return uSet[a];
    }
}

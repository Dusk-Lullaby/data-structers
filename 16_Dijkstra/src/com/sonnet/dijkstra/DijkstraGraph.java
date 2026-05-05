package com.sonnet.dijkstra;

import com.Sonnet.matrix_graph.MatrixGraph;

import java.util.ArrayDeque;
import java.util.Deque;

public class DijkstraGraph<T> {
    // 邻接矩阵
    final private MatrixGraph<T> graph;

    // 路径数组
    private int[] path;

    // 是否被激活
    private boolean[] mark;

    // 需要的距离
    private int[] dist;

    public DijkstraGraph(MatrixGraph<T> graph) {
        this.graph = graph;
        this.dist = new int[this.graph.getVertexNum()];
        this.path = new int[this.graph.getVertexNum()];
        this.mark = new boolean[this.graph.getVertexNum()];
    }

    public void getDijkstraGraph(int start) {
        MatrixGraph.MatrixEdge[][] edges = this.graph.getEdges();
        // 初始化
        for (int i = 0; i < this.graph.getVertexNum(); i++) {
            dist[i] = edges[start][i].getMatrixEdge();
            mark[i] = false;
            if (dist[i] < this.graph.getINF()) {
                this.path[i] = start;
            } else {
                this.path[i] = this.graph.getINF();
            }
        }
        mark[start] = true;
        path[start] = -1;

        // 还需要激活 vertexNum - 1 个节点
        for (int i = 0; i < this.graph.getVertexNum() - 1; i++) {
            // 获取最小值
            int min = this.graph.getINF();
            int tmpIndex = -1;
            for (int j = 0; j < this.graph.getVertexNum(); j++) {
                if (!mark[j] && min > this.dist[j]) {
                    min = this.dist[j];
                    tmpIndex = j;
                }
            }
            if (tmpIndex == -1) break;
            mark[tmpIndex] = true;

            for (int j = 0; j < this.graph.getVertexNum(); j++) {
                if (!this.mark[j] && this.dist[j] > this.dist[tmpIndex] + edges[tmpIndex][j].getMatrixEdge()) {
                    this.dist[j] = this.dist[tmpIndex] + edges[tmpIndex][j].getMatrixEdge();
                    this.path[j] = tmpIndex;
                }
            }
        }
    }

    public void show(int pos) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (this.path[pos] != -1) {
            stack.push(pos);
            pos = path[pos];
        }
        stack.push(pos);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "\t");
        }
        System.out.println();
    }
}

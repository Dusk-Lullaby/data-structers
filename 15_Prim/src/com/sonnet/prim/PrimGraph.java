package com.sonnet.prim;

import com.Sonnet.matrix_graph.MatrixGraph;
import com.sonnet.edge_set.EdgeSet;

import java.util.ArrayList;
import java.util.List;

public class PrimGraph<T> {
    private final MatrixGraph<T> matrixGraph;           // 邻接矩阵
    private List<EdgeSet> result;                       // 集合，存储最短路径

    public PrimGraph(MatrixGraph<T> matrixGraph) {
        this.matrixGraph = matrixGraph;
        this.result = new ArrayList<>();
    }

    public List<EdgeSet> getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "PrimGraph{" +
                "result=" + result +
                '}';
    }

    public int primMatrixGraph(int startV) {
        // 赋值
        int vertexNum = this.matrixGraph.getVertexNum();
        MatrixGraph.MatrixEdge[][] edges = this.matrixGraph.getEdges();
        // 权值cost
        int[] cost = new int[vertexNum];
        // 从哪个点开始访问
        int[] visited = new int[vertexNum];
        // 激活点
        boolean[] mark = new boolean[vertexNum];

        // 更新第一个节点激活状态
        for (int i = 0; i < vertexNum; i++) {
            cost[i] = edges[startV][i].getMatrixEdge();
            // 更新visit信息，说明从哪个节点开始访问i
            if (edges[startV][i].getMatrixEdge() < this.matrixGraph.getINF()) {
                visited[i] = startV;
            }
        }
        mark[startV] = true;

        int sum = 0;
        // 动态激活节点，查找最小值，添加到result边集数组
        // 查找 n - 1 个最小生成树的的边
        for (int i = 0; i < vertexNum - 1; i++) {
            int k = 0;
            int min = this.matrixGraph.getINF();
            for (int j = 0; j < vertexNum; j++) {
                // 从权值数组里找到未激活的点。并且小于当前最小值
                if (!mark[j] && min > cost[j]) {
                    min = cost[j];
                    k = j;
                }
            }

            // 激活最小值的节点
            mark[k] = true;
            // 加入result集合
            this.result.add(new EdgeSet(visited[k], k, min));
            sum += min;

            for (int j = 0; j < vertexNum; j++) {
                // 激活k号节点，它的边比之前的cost小
                if (!mark[j] && cost[j] > edges[k][j].getMatrixEdge()) {
                    cost[j] = edges[k][j].getMatrixEdge();
                    visited[j] = k;
                }
            }
        }

        return sum;
    }
}

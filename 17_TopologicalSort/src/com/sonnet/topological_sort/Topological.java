package com.sonnet.topological_sort;

import com.Sonnet.adjacency_list.AdjacencyList;

import java.util.ArrayDeque;
import java.util.Deque;

public class Topological<T> {

    public boolean topologicalSort(final AdjacencyList<T> graph) {
        // 申请入度数组
        int[] inDegree = new int[graph.getNodeNum()];
        AdjacencyList.ArcNode<T>[] nodes = graph.getNodes();
        // 将入度加入到数组中
        for (int i = 0; i < graph.getNodeNum(); i++) {
            // 如果有入度
            if (nodes[i].getFirstEdge() != null) {
                AdjacencyList.ArcEdge edge = nodes[i].getFirstEdge();
                while (edge != null) {
                    inDegree[edge.getNumber()]++;
                    edge = edge.getNext();
                }
            }
        }

        // 申请栈
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : inDegree) {
            // 如果度为0 就压入栈
            if (i == 0) {
                stack.push(i);
            }
        }

        int count = 0;
        // 出栈，直到栈为空
        while(!stack.isEmpty()) {
            int index = stack.pop();
            count++;
            visitNode(nodes[index]);
            AdjacencyList.ArcEdge edge = nodes[index].getFirstEdge();
            while (edge != null) {
                inDegree[edge.getNumber()]--;
                if (inDegree[edge.getNumber()] == 0) {
                    stack.push(edge.getNumber());
                }
                edge = edge.getNext();
            }
        }

        return count == graph.getNodeNum();
    }

    private void visitNode(AdjacencyList.ArcNode<T> node) {
        System.out.print(node.getShow() + "\t");
    }
}

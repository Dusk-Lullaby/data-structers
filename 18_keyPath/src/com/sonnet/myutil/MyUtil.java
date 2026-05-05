package com.sonnet.myutil;

import com.Sonnet.adjacency_list.AdjacencyList;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyUtil {

    private MyUtil() {
        throw new AssertionError("Utility class cannot be instantiated");
    }

    public static <T> void KeyPath(AdjacencyList<T> graph) {
        // 申请ETV和LTV数组
        int[] ETV = new int[graph.getNodeNum()];
        int[] LTV = new int[graph.getNodeNum()];
        topological(graph, ETV, LTV);
        showTable("ETV", ETV);
        showTable("LTV", LTV);
        for (int i = 0; i < graph.getNodeNum(); i++) {
            AdjacencyList.ArcEdge edge = graph.getNodes()[i].getFirstEdge();
            while (edge != null) {
                if (ETV[i] + edge.getWeight() == LTV[edge.getNumber()]) {
                    System.out.print(graph.getNodes()[i].getShow() + " --- " + edge.getWeight() + " --- " + graph.getNodes()[edge.getNumber()].getShow());
                    System.out.println();
                }
                edge = edge.getNext();
            }
        }
    }

    private static <T> void topological(AdjacencyList<T> graph, int[] ETV, int[] LTV) {
        // 申请入度数组
        int[] inDegree = new int[graph.getNodeNum()];
        for (int i = 0; i < graph.getNodeNum(); i++) {
            AdjacencyList.ArcEdge edge = graph.getNodes()[i].getFirstEdge();
            while (edge != null) {
                inDegree[edge.getNumber()]++;
                edge = edge.getNext();
            }
        }

        // 申请栈
        Deque<Integer> stack = new ArrayDeque<>();
        // 寻找源点，放入栈
        for (int i : inDegree) {
            if (i == 0) {
                stack.push(i);
                break;
            }
        }

        // 申请结果数组
        int[] result = new int[graph.getNodeNum()];
        int index = 0;

        int tmp = 0;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            result[index++] = tmp;
            AdjacencyList.ArcEdge edge = graph.getNodes()[tmp].getFirstEdge();
            while (edge != null) {
                if (--inDegree[edge.getNumber()] == 0) {
                    stack.push(edge.getNumber());
                }
                if (ETV[edge.getNumber()] < ETV[tmp] + edge.getWeight()) {
                    ETV[edge.getNumber()] = ETV[tmp] + edge.getWeight();
                }
                edge = edge.getNext();
            }
        }

        if (index < graph.getNodeNum()) {
            // 或者抛出 IllegalArgumentException (非法参数异常)
            throw new IllegalArgumentException("The provided graph contains a circular dependency.");
        }

        for (int i = 0; i < graph.getNodeNum(); i++) {
            LTV[i] = ETV[tmp];
        }

        while (index != 0) {
            int getTopological = result[--index];
            AdjacencyList.ArcEdge edge = graph.getNodes()[getTopological].getFirstEdge();
            while (edge != null) {
                if (LTV[getTopological] + edge.getWeight() > LTV[edge.getNumber()]) {
                    LTV[getTopological] = LTV[edge.getNumber()] - edge.getWeight();
                }
                edge = edge.getNext();
            }
        }
    }

    private static void showTable(String name, int[] table) {
        System.out.println(name + ":");
        for (int i : table) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}

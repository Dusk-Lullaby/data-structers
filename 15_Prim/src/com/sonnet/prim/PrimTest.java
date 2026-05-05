package com.sonnet.prim;

import com.Sonnet.matrix_graph.MatrixGraph;

public class PrimTest {

    public static void main(String[] args) {
        test();
    }

    public static MatrixGraph<String> toMatrixGraph() {
        String[] show = {"A", "B", "C", "D", "E", "F", "G"};
        MatrixGraph<String> matrixGraph = new MatrixGraph<>(show, show.length, false, (int) 1E4);
        matrixGraph.addMatrixGraph(0, 1, 12);
        matrixGraph.addMatrixGraph(0, 5, 16);
        matrixGraph.addMatrixGraph(0, 6, 14);
        matrixGraph.addMatrixGraph(1, 2, 10);
        matrixGraph.addMatrixGraph(1, 5, 7);
        matrixGraph.addMatrixGraph(2, 3, 3);
        matrixGraph.addMatrixGraph(2, 4, 5);
        matrixGraph.addMatrixGraph(2, 5, 6);
        matrixGraph.addMatrixGraph(3, 4, 4);
        matrixGraph.addMatrixGraph(4, 5, 2);
        matrixGraph.addMatrixGraph(4, 6, 8);
        matrixGraph.addMatrixGraph(5, 6, 9);

        return matrixGraph;
    }

    public static void test() {
        PrimGraph<String> graph = new PrimGraph<>(toMatrixGraph());
        System.out.println(graph.primMatrixGraph(0));
        System.out.println(graph.getResult());
    }

}

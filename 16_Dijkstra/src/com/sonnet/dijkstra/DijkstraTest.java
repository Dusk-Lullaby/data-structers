package com.sonnet.dijkstra;

import com.Sonnet.matrix_graph.MatrixGraph;

public class DijkstraTest {

    public static void main(String[] args) {
        Integer[] show = {0, 1, 2, 3, 4, 5, 6};
        MatrixGraph<Integer> matrixGraph = new MatrixGraph<>(show, show.length, true, 999999);
        matrixGraph.addMatrixGraph(0, 1, 4);
        matrixGraph.addMatrixGraph(0, 2, 6);
        matrixGraph.addMatrixGraph(0, 3, 6);
        matrixGraph.addMatrixGraph(1, 4, 7);
        matrixGraph.addMatrixGraph(1, 2, 1);
        matrixGraph.addMatrixGraph(2, 4, 6);
        matrixGraph.addMatrixGraph(2, 5, 4);
        matrixGraph.addMatrixGraph(3, 2, 2);
        matrixGraph.addMatrixGraph(3, 5, 5);
        matrixGraph.addMatrixGraph(4, 6, 6);
        matrixGraph.addMatrixGraph(5, 4, 1);
        matrixGraph.addMatrixGraph(5, 6, 8);

        DijkstraGraph<Integer> graph = new DijkstraGraph<>(matrixGraph);
        graph.getDijkstraGraph(0);
        graph.show(5);
        graph.show(6);
    }
}

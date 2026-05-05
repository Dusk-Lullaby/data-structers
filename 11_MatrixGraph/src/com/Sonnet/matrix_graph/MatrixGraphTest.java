package com.Sonnet.matrix_graph;

public class MatrixGraphTest {

    public static void main(String[] args) {
        String[] shows = {"V1", "V2", "V3", "V4", "V5", "V6", "V7", "v8"};

        MatrixGraph<String> graph = new MatrixGraph<>(shows, shows.length, false, 0);
        graph.addMatrixGraph(0, 1, 1);
        graph.addMatrixGraph(0, 2, 1);
        graph.addMatrixGraph(1, 3, 1);
        graph.addMatrixGraph(1, 4, 1);
        graph.addMatrixGraph(3, 7, 1);
        graph.addMatrixGraph(4, 7, 1);
        graph.addMatrixGraph(2, 5, 1);
        graph.addMatrixGraph(2, 6, 1);
        graph.addMatrixGraph(5, 6, 1);

        System.out.println("deep: ");
        graph.DFSMatrixGraph(0);
        System.out.println();
        graph.resetVisited();
        System.out.println("wide: ");
        graph.BFSMatrixGraphTravel(0);
        System.out.println();
        System.out.println("have edge :" + graph.getEdgeNum());
    }
}

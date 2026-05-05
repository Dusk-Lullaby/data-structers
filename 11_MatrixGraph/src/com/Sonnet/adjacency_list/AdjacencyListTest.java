package com.Sonnet.adjacency_list;

public class AdjacencyListTest {

    public static void main(String[] args) {

        String[] shows = {"A", "B", "C", "D", "E"};

        AdjacencyList<String> graph = new AdjacencyList<>(shows.length);
        graph.initAGraph(shows, true);

        graph.addAGraphEdge(0, 3, 1);
        graph.addAGraphEdge(0, 2, 1);
        graph.addAGraphEdge(0, 1, 1);
        graph.addAGraphEdge(2, 3, 1);
        graph.addAGraphEdge(3, 4, 1);

        graph.DFSAGraphTravel(0);
        System.out.println();
        graph.BFSAGraphTravel(0);
        System.out.println();

        graph.releaseAGraph();
    }
}

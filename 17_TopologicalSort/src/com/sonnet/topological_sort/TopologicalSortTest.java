package com.sonnet.topological_sort;

import com.Sonnet.adjacency_list.AdjacencyList;

public class TopologicalSortTest {

    public static void main(String[] args) {

        AdjacencyList<String> AGraph = createAGraph();
        Topological<String> graph = new Topological<>();
        boolean result = graph.topologicalSort(AGraph);
        System.out.println();
        System.out.println("result: " + result);
    }

    public static AdjacencyList<String> createAGraph() {
        String[] shows = {"0", "1", "2", "3", "4", "5", "6"};
        AdjacencyList<String> graph = new AdjacencyList<>(shows.length);
        graph.initAGraph(shows, true);
        graph.addAGraphEdge(0, 1, 1);
        graph.addAGraphEdge(0, 2, 1);
        graph.addAGraphEdge(0, 3, 1);
        graph.addAGraphEdge(1, 2, 1);
        graph.addAGraphEdge(1, 4, 1);
        graph.addAGraphEdge(2, 4, 1);
        graph.addAGraphEdge(2, 5, 1);
        graph.addAGraphEdge(3, 5, 1);
        graph.addAGraphEdge(4, 6, 1);
        graph.addAGraphEdge(5, 4, 1);
        graph.addAGraphEdge(5, 6, 1);

        return graph;
    }
}

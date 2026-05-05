package com.sonnet.key_path;

import com.Sonnet.adjacency_list.AdjacencyList;
import com.sonnet.myutil.MyUtil;

public class KeyPathTest {

    public static void main(String[] args) {
        AdjacencyList<String> graph = setupAGraph();
        MyUtil.KeyPath(graph);
    }

    public static AdjacencyList<String> setupAGraph() {
        String[] names = {"V0", "V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8"};
        AdjacencyList<String> graph = new AdjacencyList<>(names.length);
        graph.initAGraph(names, true);
        graph.addAGraphEdge(0, 1, 6);
        graph.addAGraphEdge(0, 2, 4);
        graph.addAGraphEdge(0, 3, 5);
        graph.addAGraphEdge(1, 4, 1);
        graph.addAGraphEdge(2, 4, 1);
        graph.addAGraphEdge(3, 5, 2);
        graph.addAGraphEdge(4, 6, 9);
        graph.addAGraphEdge(4, 7, 7);
        graph.addAGraphEdge(5, 7, 4);
        graph.addAGraphEdge(6, 8, 2);
        graph.addAGraphEdge(7, 8, 4);

        return graph;
    }
}

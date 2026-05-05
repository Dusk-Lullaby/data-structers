package com.Sonnt.cross_link_graph;

public class CrossLinkGraphTest {

    public static void main(String[] args) {

        String[] names = {"V0", "V1", "V2", "V3"};
        CrossLinkGraph<String> graph = new CrossLinkGraph<>(names.length);
        graph.initCrossGraph(names);
        graph.addArcBox(3, 0, 1);
        graph.addArcBox(0, 1, 1);
        graph.addArcBox(0, 2, 1);
        graph.addArcBox(2, 1, 1);
        graph.addArcBox(1, 2, 1);

        System.out.println(graph.inDegreeVertex(0));
        System.out.println(graph.outDegreeVertex(0));

        System.out.println("graph have edge:" + graph.getEdgeNum());
    }
}

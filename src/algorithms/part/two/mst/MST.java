package algorithms.part.two.mst;

import algorithms.part.two._1_graph.Edge;

// Minimum Spanning Tree
public interface MST {

    Iterable<Edge> mstEdges();

    double weight();

}

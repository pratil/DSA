package algorithms.part.two.mst;

import algorithms.part.one._2_bag.Bag;
import algorithms.part.one._6_binaryheap.MinHeapTree;
import algorithms.part.two._1_graph.Edge;
import algorithms.part.two._1_graph.EdgeWeightedUndirectedGraph;

public class PrimsMST implements MST {

    private final boolean[] visited;
    private final MinHeapTree<Edge> minHeapTree;
    private final Bag<Edge> mstEdges;
    private double weight;

    public PrimsMST(EdgeWeightedUndirectedGraph edgeWeightedUndirectedGraph) {
        int noOfVertices = edgeWeightedUndirectedGraph.noOfVertices(), first, second;
        mstEdges = new Bag<>();
        minHeapTree = new MinHeapTree<>();
        visited = new boolean[noOfVertices];
        visit(edgeWeightedUndirectedGraph, 0);
        while (mstEdges.size() != noOfVertices - 1) {
            Edge minEdge = minHeapTree.delete();
            first = minEdge.either();
            second = minEdge.other(first);
            if (visited[first] && visited[second])
                continue;
            mstEdges.add(minEdge);
            weight += minEdge.weight();
            if (visited[first]) visit(edgeWeightedUndirectedGraph, second);
            if (visited[second]) visit(edgeWeightedUndirectedGraph, first);
        }
    }

    private void visit(EdgeWeightedUndirectedGraph edgeWeightedUndirectedGraph, int vertex) {
        if (visited[vertex])
            return;
        visited[vertex] = true;
        for (Edge edge : edgeWeightedUndirectedGraph.edges(vertex))
            if (!visited[edge.other(vertex)])
                minHeapTree.insert(edge);
    }

    @Override
    public Iterable<Edge> mstEdges() {
        return mstEdges;
    }

    @Override
    public double weight() {
        return weight;
    }
}

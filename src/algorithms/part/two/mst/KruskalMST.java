package algorithms.part.two.mst;

import algorithms.part.one._1_unionfind.QuickUnionWithPathCompression;
import algorithms.part.one._1_unionfind.UnionFind;
import algorithms.part.one._2_bag.Bag;
import algorithms.part.one._6_binaryheap.MinHeapTree;
import algorithms.part.two._1_graph.Edge;
import algorithms.part.two._1_graph.EdgeWeightedUndirectedGraph;

public class KruskalMST implements MST {

    private final Bag<Edge> mstEdges;
    private double weight;

    public KruskalMST(EdgeWeightedUndirectedGraph edgeWeightedUndirectedGraph) {
        int noOfVertices = edgeWeightedUndirectedGraph.noOfVertices();
        mstEdges = new Bag<>();
        weight = 0.0;
        MinHeapTree<Edge> minHeapTree = new MinHeapTree<>();
        for (Edge edge : edgeWeightedUndirectedGraph.edges())
            minHeapTree.insert(edge);
        UnionFind unionFind = new QuickUnionWithPathCompression(noOfVertices);
        while (!minHeapTree.isEmpty() && mstEdges.size() < noOfVertices - 1) {
            Edge edge = minHeapTree.delete();
            int first = edge.either(), second = edge.other(first);
            if (!unionFind.find(first, second)) {
                unionFind.union(first, second);
                mstEdges.add(edge);
                weight += edge.weight();
            }
        }
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

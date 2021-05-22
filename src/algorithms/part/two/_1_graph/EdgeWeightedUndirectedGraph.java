package algorithms.part.two._1_graph;

import algorithms.part.one._2_bag.Bag;
import util.InputHelper;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class EdgeWeightedUndirectedGraph {

    private final int noOfVertices;
    private int noOfEdges;
    private final Bag<Edge>[] vertices;

    public EdgeWeightedUndirectedGraph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        this.noOfEdges = 0;
        vertices = new Bag[noOfVertices];
        for (int i = 0; i < noOfVertices; i++)
            vertices[i] = new Bag<>();
    }

    private EdgeWeightedUndirectedGraph(List<String> lines) {
        this(Integer.parseInt(lines.get(0)));
        int noOfEdges = Integer.parseInt(lines.get(1));
        String[] edge;
        for (int i = 0; i < noOfEdges; i++) {
            edge = lines.get(i + 2).split("\\s+");
            addEdge(new Edge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]), Double.parseDouble(edge[2])));
        }
    }

    public EdgeWeightedUndirectedGraph(String filename) throws FileNotFoundException {
        this(InputHelper.read(filename));
    }

    public void addEdge(Edge edge) {
        int first = edge.either();
        int second = edge.other(first);
        vertices[first].add(edge);
        if (first != second)
            vertices[second].add(edge);
        noOfEdges++;
    }

    public int noOfVertices() {
        return noOfVertices;
    }

    public int noOfEdges() {
        return noOfEdges;
    }

    public Iterable<Edge> edges(int vertex) {
        return vertices[vertex];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> edges = new Bag<>();
        for (int vertex = 0; vertex < noOfVertices; vertex++) {
            for (Edge edge : edges(vertex)) {
                int other = edge.other(vertex);
                if (vertex <= other)
                    edges.add(edge);
            }
        }
        return edges;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EdgeWeightedUndirectedGraph { " + "\n noOfVertices=").append(noOfVertices)
                .append(", noOfEdges=").append(noOfEdges)
                .append(",\n vertices= [");
        Arrays.stream(vertices).forEach(
                edges -> {
                    for (Edge edge : edges)
                        stringBuilder.append("\n  ").append(edge);
                }
        );
        stringBuilder.append("\n ]");
        stringBuilder.append("\n}");
        return stringBuilder.toString();
    }
}

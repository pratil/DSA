package algorithms.part.two._1_graph;

import algorithms.part.one._2_bag.Bag;
import util.InputHelper;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class EdgeWeightedDirectedGraph {

    private final Bag<DirectedEdge>[] vertices;
    private final int noOfVertices;
    private int noOfEdges;

    public EdgeWeightedDirectedGraph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        vertices = new Bag[noOfVertices];
        for (int i = 0; i < noOfVertices; i++)
            vertices[i] = new Bag<>();
    }

    private EdgeWeightedDirectedGraph(List<String> lines) {
        this(Integer.parseInt(lines.get(0)));
        int noOfEdges = Integer.parseInt(lines.get(1));
        String[] edge;
        for (int i = 0; i < noOfEdges; i++) {
            edge = lines.get(i + 2).split("\\s+");
            addEdge(new DirectedEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]), Double.parseDouble(edge[2])));
        }
    }

    public EdgeWeightedDirectedGraph(String filename) throws FileNotFoundException {
        this(InputHelper.read(filename));
    }


    public void addEdge(DirectedEdge directedEdge) {
        int from = directedEdge.from();
        vertices[from].add(directedEdge);
        noOfEdges++;
    }

    public int noOfVertices() {
        return noOfVertices;
    }

    public int noOfEdges() {
        return noOfEdges;
    }

    public Iterable<DirectedEdge> edges(int vertex) {
        return vertices[vertex];
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> edges = new Bag<>();
        for (int vertex = 0; vertex < noOfVertices; vertex++)
            for (DirectedEdge directedEdge : edges(vertex))
                edges.add(directedEdge);
        return edges;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EdgeWeightedDirectedGraph { " + "\n noOfVertices=").append(noOfVertices)
                .append(", noOfEdges=").append(noOfEdges)
                .append(",\n vertices= [");
        Arrays.stream(vertices).forEach(
                edges -> {
                    for (DirectedEdge directedEdge : edges)
                        stringBuilder.append("\n  ").append(directedEdge);
                }
        );
        stringBuilder.append("\n ]");
        stringBuilder.append("\n}");
        return stringBuilder.toString();
    }

}

package algorithms.part.two._1_graph;

import algorithms.part.one._2_bag.Bag;
import util.InputHelper;

import java.io.FileNotFoundException;
import java.util.List;

public class UndirectedGraph implements Graph {

    private final Bag<Integer>[] vertices;
    private final int noOfVertices;
    private int noOfEdges;

    public UndirectedGraph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        vertices = new Bag[noOfVertices];
        for (int i = 0; i < noOfVertices; i++)
            vertices[i] = new Bag<>();
    }

    private UndirectedGraph(List<String> lines) {
        this(Integer.parseInt(lines.get(0)));
        int noOfEdges = Integer.parseInt(lines.get(1));
        String[] edge;
        for (int i = 0; i < noOfEdges; i++) {
            edge = lines.get(i + 2).split("\\s+");
            addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
        }
    }

    public UndirectedGraph(String filename) throws FileNotFoundException {
        this(InputHelper.read(filename));
    }

    @Override
    public void addEdge(int first, int second) {
//        System.out.println("added edge: " + first + " ---- " + second);
        vertices[first].add(second);
        if (first != second)
            vertices[second].add(first);
        noOfEdges++;
    }

    @Override
    public int noOfVertices() {
        return noOfVertices;
    }

    @Override
    public int noOfEdges() {
        return noOfEdges;
    }

    @Override
    public Iterable<Integer> adjacentVertices(int vertex) {
        return vertices[vertex];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UndirectedGraph{").append('\n')
                .append(" noOfVertices=").append(noOfVertices)
                .append(", noOfEdges=").append(noOfEdges).append(",\n");
        stringBuilder.append(" edges = {\n");
        for (int i = 0; i < noOfVertices; i++)
            for (int j : vertices[i])
                stringBuilder.append(" ").append(i).append(" -> ").append(j).append("\n");
        stringBuilder.append(" }\n");
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

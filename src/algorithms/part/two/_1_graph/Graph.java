package algorithms.part.two._1_graph;

public interface Graph {

    default void addEdge(int first, int second) {
    }

    int noOfVertices();

    int noOfEdges();

    Iterable<Integer> adjacentVertices(int vertex);

}

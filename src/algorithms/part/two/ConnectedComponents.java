package algorithms.part.two;

import algorithms.part.two._1_graph.Graph;

import java.util.Arrays;

public class ConnectedComponents {

    private final boolean[] visited;
    private final int[] component;
    private int noOfComponents;

    public ConnectedComponents(Graph graph) {
        int noOfVertices = graph.noOfVertices();
        visited = new boolean[noOfVertices];
        component = new int[noOfVertices];
        noOfComponents = 0;
        for (int vertex = 0; vertex < noOfVertices; vertex++) {
            if (!visited[vertex]) {
                component[vertex] = noOfComponents;
                dfs(graph, vertex);
                noOfComponents++;
            }
        }
        assert assertAllVertexVisited();
    }

    public boolean connected(int first, int second) {
        return component[first] == component[second];
    }

    public int count() {
        return noOfComponents;
    }

    public int componentId(int vertex) {
        return component[vertex];
    }

    private void dfs(Graph graph, int source) {
        visited[source] = true;
        for (int adjacentVertex : graph.adjacentVertices(source)) {
            if (!visited[adjacentVertex]) {
                component[adjacentVertex] = component[source];
                dfs(graph, adjacentVertex);
            }
        }
    }

    private boolean assertAllVertexVisited() {
        for (boolean isVisited : visited)
            if (!isVisited)
                throw new FullGraphNotCoveredException();
        return true;
    }

    @Override
    public String toString() {
        return "ConnectedComponents{" +
                " noOfComponents=" + noOfComponents +
                ", component=" + Arrays.toString(component) +
                " }";
    }
}

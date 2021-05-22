package algorithms.part.two;

import algorithms.part.two._1_graph.DirectedGraph;

import java.util.Arrays;

public class StrongConnectedComponents {

    private final boolean[] visited;
    private final int[] component;
    private int noOfComponents;

    public StrongConnectedComponents(DirectedGraph graph) {
        int noOfVertices = graph.noOfVertices();
        visited = new boolean[noOfVertices];
        component = new int[noOfVertices];
        noOfComponents = 0;
        DirectedGraph reverse = graph.reverse();
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(reverse);
        for (int vertex : depthFirstOrder.reversePostOrder()) {
            if (!visited[vertex]) {
                component[vertex] = noOfComponents;
                dfs(graph, vertex);
                noOfComponents++;
            }
        }
        assert assertAllVertexVisited();
    }

    private void dfs(DirectedGraph graph, int vertex) {
        visited[vertex] = true;
        for (int adjacentVertex : graph.adjacentVertices(vertex)) {
            if (!visited[adjacentVertex]) {
                component[adjacentVertex] = component[vertex];
                dfs(graph, adjacentVertex);
            }
        }
    }

    public int componentId(int vertex) {
        return component[vertex];
    }

    public boolean connected(int first, int second) {
        return component[first] == component[second];
    }

    public int count() {
        return noOfComponents;
    }

    private boolean assertAllVertexVisited() {
        for (boolean isVisited : visited)
            if (!isVisited)
                throw new FullGraphNotCoveredException();
        return true;
    }

    @Override
    public String toString() {
        return "StrongConnectedComponents{" +
                " noOfComponents=" + noOfComponents +
                ", component=" + Arrays.toString(component) +
                " }";
    }
}

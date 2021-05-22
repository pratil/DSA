package algorithms.part.two;

import algorithms.part.one._3_stack.Stack;
import algorithms.part.two._1_graph.Graph;

// Topological Sort
public class DepthFirstOrder {

    private final boolean[] visited;
    private final Stack<Integer> reversePostOrder;

    public DepthFirstOrder(Graph graph) {
        int noOfVertices = graph.noOfVertices();
        visited = new boolean[noOfVertices];
        reversePostOrder = new Stack<>();
        for (int i = 0; i < noOfVertices; i++)
            if (!visited[i])
                dfs(graph, i);
    }

    private void dfs(Graph graph, int vertex) {
        visited[vertex] = true;
        for (int adjacentVertex : graph.adjacentVertices(vertex))
            if (!visited[adjacentVertex])
                dfs(graph, adjacentVertex);
        reversePostOrder.push(vertex);
    }

    public Iterable<Integer> reversePostOrder() {
        return reversePostOrder;
    }

}

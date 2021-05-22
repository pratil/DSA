package algorithms.part.two;

import algorithms.part.one._3_stack.Stack;
import algorithms.part.two._1_graph.Graph;

public class DepthFirstSearch extends Paths {

    private final boolean[] visited;
    private final int[] edgeTo;
    private final int source;

    public DepthFirstSearch(Graph graph, int source) {
        this.source = source;
        visited = new boolean[graph.noOfVertices()];
        edgeTo = new int[graph.noOfVertices()];
        dfs(graph, source);
    }

    @Override
    public boolean hasPathTo(int vertex) {
        return visited[vertex];
    }

    @Override
    public Iterable<Integer> pathTo(int vertex) {
        if (!hasPathTo(vertex))
            return null;
        Stack<Integer> stack = new Stack<>();
        while (edgeTo[vertex] != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        stack.push(source);
        return stack;
    }

    private void dfs(Graph graph, int vertex) {
        visited[vertex] = true;
        for (int adjacentVertex : graph.adjacentVertices(vertex)) {
            if (!visited[adjacentVertex]) {
                dfs(graph, adjacentVertex);
                edgeTo[adjacentVertex] = vertex;
            }
        }
    }

}

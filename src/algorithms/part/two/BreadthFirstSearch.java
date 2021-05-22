package algorithms.part.two;

import algorithms.part.one._3_stack.Stack;
import algorithms.part.one._4_queue.Queue;
import algorithms.part.two._1_graph.Graph;

public class BreadthFirstSearch extends Paths {

    private final boolean[] visited;
    private final int[] edgeTo;
    private final int source;

    public BreadthFirstSearch(Graph graph, int source) {
        this.source = source;
        visited = new boolean[graph.noOfVertices()];
        edgeTo = new int[graph.noOfVertices()];
        bfs(graph);
    }

    @Override
    public boolean hasPathTo(int vertex) {
        return visited[vertex];
    }

    @Override
    public Iterable<Integer> pathTo(int vertex) {
        Stack<Integer> stack = new Stack<>();
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        stack.push(source);
        return stack;
    }

    private void bfs(Graph graph) {
        int vertex;
        Queue<Integer> queue = new Queue<>();
        queue.add(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            vertex = queue.poll();
            for (int adjacentVertex : graph.adjacentVertices(vertex)) {
                if (!visited[adjacentVertex]) {
                    edgeTo[adjacentVertex] = vertex;
                    visited[vertex] = true;
                    queue.add(adjacentVertex);
                }
            }
        }
    }
}

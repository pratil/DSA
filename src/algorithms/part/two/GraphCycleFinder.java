package algorithms.part.two;

import algorithms.part.one._3_stack.Stack;
import algorithms.part.two._1_graph.Graph;


public class GraphCycleFinder {

    private final int WHITE = 0;
    private final int GRAY = 1;
    private final int BLACK = 2;

    private final int[] colour;
    private final int[] edgeTo;
    private Stack<Integer> cycle;
    private final boolean cyclePresent;

    public GraphCycleFinder(Graph graph) {
        int noOfVertices = graph.noOfVertices();
        colour = new int[noOfVertices];
        edgeTo = new int[noOfVertices];
        for (int i = 0; i < noOfVertices; i++)
            if (colour[i] == WHITE)
                dfs(graph, i);
        cyclePresent = cycle != null;
    }

    private void dfs(Graph graph, int vertex) {
        colour[vertex] = GRAY;
        for (int adjacentVertex : graph.adjacentVertices(vertex)) {
            if (cycle != null)
                return;
            if (colour[adjacentVertex] != GRAY) {
                edgeTo[adjacentVertex] = vertex;
                dfs(graph, adjacentVertex);
            } else {
                cycle = new Stack<>();
                for (int cyclicVertex = vertex; cyclicVertex != adjacentVertex; cyclicVertex = edgeTo[cyclicVertex])
                    cycle.push(cyclicVertex);
                cycle.push(adjacentVertex);
                cycle.push(vertex);
                return;
            }
        }
        colour[vertex] = BLACK;
    }

    public boolean isCyclic() {
        return cyclePresent;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

}

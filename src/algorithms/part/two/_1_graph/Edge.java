package algorithms.part.two._1_graph;

public class Edge implements Comparable<Edge> {

    private final int first;
    private final int second;
    private final double weight;

    public Edge(int first, int second, double weight) {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }

    public int either() {
        return first;
    }

    public int other(int vertex) {
        if (first == vertex)
            return second;
        return first;
    }

    public double weight() {
        return weight;
    }

    @Override
    public int compareTo(Edge that) {
        return Double.compare(this.weight, that.weight);
    }

    @Override
    public String toString() {
        return first + "--" + second + " " + weight;
    }
}

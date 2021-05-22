package algorithms.part.two._1_graph;

public class DirectedEdge implements Comparable<DirectedEdge> {

    private final int from;
    private final int to;
    private final double weight;

    public DirectedEdge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int from() {
        return from;
    }

    public int to() {
        return to;
    }

    public double weight() {
        return weight;
    }

    @Override
    public int compareTo(DirectedEdge that) {
        return Double.compare(this.weight, that.weight);
    }

    @Override
    public String toString() {
        return from + "-->" + to + " " + weight;
    }

}

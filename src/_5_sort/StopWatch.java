package _5_sort;

public class StopWatch {
    private long time;

    StopWatch() {
        time = System.nanoTime();
    }

    public double getTime() {
        long elapsedTime = System.nanoTime() - this.time;
        return (double) elapsedTime / 1_000_000_000;
    }

    public void reset() {
        time = System.nanoTime();
    }
}

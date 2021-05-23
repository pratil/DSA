package algorithms.part.one._5_sort;

//A class to calculate the time difference between a block/line of code
public class StopWatch {

    private long time; // to store the time;

    // to initialize the stopwatch and also to start it
    StopWatch() {
        time = System.nanoTime();
    }

    // to get the elapsed time till now
    public double getTime() {
        long elapsedTime = System.nanoTime() - this.time;
        return (double) elapsedTime / 1_000_000_000;
    }

    // to reset the time and start the stopwatch again
    public void reset() {
        time = System.nanoTime();
    }
}

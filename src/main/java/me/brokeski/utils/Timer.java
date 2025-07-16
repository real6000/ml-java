package me.brokeski.utils;

/**
 * Timer utility to measure elapsed time in milliseconds or seconds.
 * Can be used to benchmark operations like forward passes or training epochs.
 *
 * 2025
 */

public class Timer {

    private long startTime;

    /**
     * Starts or restarts the timer.
     */
    public void start(){
        startTime = System.nanoTime();
    }

    /**
     * Returns the elapsed time since start in milliseconds.
     *
     * @return Elapsed time in milliseconds.
     */
    public long elapsedMillis(){
        return (System.nanoTime() - startTime) / 1000000;
    }

    /**
     * Returns the elapsed time since start in seconds.
     *
     * @return Elapsed time in seconds (as a double).
     */
    public double elapsedSeconds(){
        return (System.nanoTime()-startTime) / 1000000000.0;
    }
}

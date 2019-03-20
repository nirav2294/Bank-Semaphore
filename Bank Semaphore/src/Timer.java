/**
 * This class calculates the elapsedTime and the elapsed time for the bank 
 * simulation.
 * @author Nirav Patel
 *
 */

public class Timer {
    private static long startTime;

    public static void initTimer(){
        startTime = System.currentTimeMillis();
    }

    public static long getElapsedTime(){
        return (System.currentTimeMillis() - startTime) / 1000;
    }

    public static long getElapsedTimeSimulatedWorld(){
        return (System.currentTimeMillis() - startTime) / 100;
    }
}

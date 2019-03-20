/**
 * This class declares four variables that are necessary to get the details 
 * about the bank. The variables declared are numberOfTellers, meanArrivalTime,
 * meanServiceTime, simulationTime, The class also defines the getters and 
 * setters method for all the variables. and a print method that prints all the
 * details of the varibales.
 * @author Nirav Patel
 *
 */

public class Parameters {

    private int numberOfTellers;
    private int meanArrivalTime;
    private int meanServiceTime;
    private int simulationTime;

    public int getNumberOfTellers() {
        return numberOfTellers;
    }

    public int getMeanArrivalTime() {
        return meanArrivalTime;
    }

    public int getMeanServiceTime() {
        return meanServiceTime;
    }

    public int getSimulationTime() {
        return simulationTime;
    }

    public void setNumberOfTellers(int numberOfTellers) {
        this.numberOfTellers = numberOfTellers;
    }

    public void setMeanArrivalTime(int meanArrivalTime) {
        this.meanArrivalTime = meanArrivalTime;
    }

    public void setMeanServiceTime(int meanServiceTime) {
        this.meanServiceTime = meanServiceTime;
    }

    public void setSimulationTime(int simulationTime) {
        this.simulationTime = simulationTime;
    }

    public void print(){
        System.out.println("Mean inter-arrival time: " + meanArrivalTime);
        System.out.println("Mean service time: " + meanServiceTime);
        System.out.println("Number of tellers: " + numberOfTellers);
        System.out.println("Length of simulation: " + simulationTime + "\n");
    }
}

/**
 * This class only contains the main method and gives the necessary calls 
 * for the the methods. Declares the new parameters object and and calls 
 * method on that object
 * @author Nirav Patel
 *
 */

public class Assignment2 {
    public static void main(String[] args) {
        try {
            Parameters parameters = new Parameters();
            parameters.setNumberOfTellers(Integer.parseInt(args[0]));
            parameters.setMeanArrivalTime(Integer.parseInt(args[1]));
            parameters.setMeanServiceTime(Integer.parseInt(args[2]));
            parameters.setSimulationTime(Integer.parseInt(args[3]));
            Thread customerGeneratorThread = new Thread(new CustomerGenerator(parameters));
            customerGeneratorThread.start();
        } catch (Exception e) {
            System.out.println("Invalid arguments!");
        }
    }
}

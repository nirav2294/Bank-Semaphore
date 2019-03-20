/**
 * 
 * This class is defined to generate a customer with all the necessary 
 * declared as below.
 * @author Nirav Patel
 */

import java.util.ArrayList;

public class CustomerGenerator implements Runnable {

    private Parameters parameters;
    private Bank bank;
    private int currentId;
    private ArrayList<Thread> customerThreads;
    private Random_Int_Mean random_int_mean;

    public CustomerGenerator(Parameters parameters) {
        this.parameters = parameters;
        Timer.initTimer();  // init the timer
        this.bank = new Bank(parameters);
        customerThreads = new ArrayList<>();
        random_int_mean = new Random_Int_Mean();
        currentId = 0;
    }

    @Override
    public void run() {
        parameters.print();

        while (!isSimulationEndTimeReached()) {
            try {
                Thread.sleep(getTimeToSleep());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!isSimulationEndTimeReached()){
                generateCustomer();
            }
        }

        // properly dispose dead threads
        while (!customerThreads.isEmpty()){
            for (int i = 0; i < customerThreads.size(); i++) {
                Thread thread = customerThreads.get(i);
                if(thread.isAlive()){
                    continue;
                }else{
                    try {
                        thread.join();
                        customerThreads.remove(i);
                        break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        // simulation ended. Print the stats
        System.out.println("\nSimulation terminated after " + bank.getCustomerCount() + " customers served");
        System.out.println("Average waiting time = " + String.format( "%.2f", bank.getAverageSimulatedWorldWaitingTime() ));

    }

    private void generateCustomer() {
        Thread customerThread = new Thread(new Customer(getNextId(), bank));
        customerThreads.add(customerThread);
        customerThread.start();
    }

    private boolean isSimulationEndTimeReached(){
        return parameters.getSimulationTime() < Timer.getElapsedTimeSimulatedWorld();
    }

    private int getNextId() {
        // no need to synchronize sine only this thread accesses
        return ++currentId;
    }

    private int getTimeToSleep() {
        return random_int_mean.random_int(parameters.getMeanArrivalTime() / 10) * 1000;
    }
}

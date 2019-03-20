
/***
 * This class has all necessary methods such as get service time for a customer, 
 * total waiting time for a customer, total number of custoemers and many more
 * @author Nirav Patel
 * 
 */
import java.util.concurrent.Semaphore;

public class Bank {
    private Semaphore semaphoreTellers;
    private Random_Int_Mean random_int_mean;
    private Parameters parameters;
    private int customerCount;
    private int totalWaitingTime;

    public Bank(Parameters parameters) {
        this.parameters = parameters;
        semaphoreTellers = new Semaphore(parameters.getNumberOfTellers(), true);
        random_int_mean = new Random_Int_Mean();
        customerCount = 0;
        totalWaitingTime = 0;
    }

    public void serveCustomer(Customer customer){
        try {
            long timeBegin = System.currentTimeMillis();
            semaphoreTellers.acquire();
            long timeEnd = System.currentTimeMillis();
            customer.printMessage("starts being served");
            incrementCustomerCount();
            addToTotalWaitingTime(timeEnd - timeBegin);
            try {
                Thread.sleep(getServeTime());
            }catch (InterruptedException e){

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphoreTellers.release();
        }
    }

    private synchronized int getServeTime(){
        return random_int_mean.random_int(parameters.getMeanServiceTime() / 10) * 1000;
    }

    private synchronized void incrementCustomerCount(){
        customerCount++;
    }

    private synchronized void addToTotalWaitingTime(long waitTime){
        totalWaitingTime += waitTime;
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public double getAverageSimulatedWorldWaitingTime() {
        return (totalWaitingTime * 0.01) / customerCount;
    }
}

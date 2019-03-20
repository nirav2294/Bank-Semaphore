/**
 * This class declares two variables one is the bank of type bank
 * and another is int with id and a print message method that prints
 *  the time that prints the time elasped and the id of the customer.
 *  A run method is also defined in the class.
 *  @author Nirav Patel
 */

public class Customer implements Runnable{

    private int id;
    private Bank bank;

    public Customer(int id, Bank bank) {
        this.id = id;
        this.bank = bank;
    }

    public void printMessage(String message){
        System.out.println("At Time \t" + Timer.getElapsedTimeSimulatedWorld() + ", Customer \t" + id + " " + message);
    }

    @Override
    public void run() {
        printMessage("arrives in line");
        bank.serveCustomer(this);
        printMessage("leaves the bank");
    }
}

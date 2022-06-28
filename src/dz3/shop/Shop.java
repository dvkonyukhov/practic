package dz3.shop;

import java.util.*;

public class Shop {
    //private final String name;
    private final List<Cash> cashes = new ArrayList<>();
    private int iterationCount;
    private final CustomerFactory customerFactory;

    public Shop(int iterationCount, int cashCount) {
        this.iterationCount = iterationCount;
        customerFactory = new CustomerFactory();
        for (int i = 1; i < cashCount + 1; i++){
            Cash cash = new Cash(("cash" + i), getRandomSpeed());
            addCash(cash);
        }
    }

    public void addCash(Cash cash) {
        cashes.add(cash);
    }

    public void startProcess() {
        while (iterationCount > 0) {
            System.out.println("_____Такт работы магазина_____");
            Customer customer = customerFactory.createCustomer();
            customer.chooseCash(cashes);
            printInfo();
            startCash();
            setJustComeIn();
            iterationCount--;
        }
    }

    private void printInfo() {

        for (Cash cash : cashes) {
            System.out.println(cash.getInfo());
        }

    }

    public void setJustComeIn() {
        for (Cash cash : cashes) {
            Queue<Customer> queue = cash.getQueue();
            for (Customer customer : queue
            ) {
                customer.setJustComeIn(false);
            }
        }
    }

    private void startCash() {
        for (Cash cash : cashes) {
            cash.serveCustomer(0);
        }
    }

    private Customer createCustomer() {
        ArrayList<Customer> listCustomers = new ArrayList<>();
        int countCustomers = 3;
        int countPurchase = 10;
        listCustomers.add(new Child(new Random().nextInt(countPurchase) + 1));
        listCustomers.add(new Man(new Random().nextInt(countPurchase) + 1));
        listCustomers.add(new Woman(new Random().nextInt(countPurchase) + 1));
        return listCustomers.get(new Random().nextInt(countCustomers));
    }

    static int getRandomSpeed() {
        return (new Random().nextInt(3) + 1);
    }
}

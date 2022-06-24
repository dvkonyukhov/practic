package dz3.shop;

import java.util.*;

public class Shop {
    //private final String name;
    private final List<Cash> cashes = new ArrayList<>();
    private int iterationCount;
    private final int cashCount;

    public Shop(int iterationCount, int cashCount) {
        //this.name = name;
        this.iterationCount = iterationCount;
        this.cashCount = cashCount;
    }

    public void addCash(Cash cash) {
        cashes.add(cash);
    }

    public void startProcess() {
        createCash(cashCount);
        while (iterationCount > 0) {
            System.out.println("_____Такт работы магазина_____");
            Customer customer = createCustomer();
            customer.chooseCash(cashes);
            getInfo();
            startCash();
            setJustComeIn();
            iterationCount--;
        }
    }

    private void getInfo() {

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
            cash.serveCustomer();
        }
    }

    private void createCash(int count) {
        for (int i = 1; i < count + 1; i++){
            Cash cash = new Cash(("cash" + i), getRandomSpeed());
            addCash(cash);
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
        return (new Random().nextInt(2) + 1);
    }
}

package dz3.shop;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Random;

public class Shop {
    private final String NAME;
    private List<Cash> cashList = new ArrayList();
    private int countTakts;
    private int countCash;

    public Shop(String name, int countTakts, int countCash) {
        this.NAME = name;
        this.countTakts = countTakts;
        this.countCash = countCash;
    }

    public void addCash(Cash cash) {
        cashList.add(cash);
    }

    public void startProcess() {
        createCash(countCash);
        while (countTakts > 0) {
            System.out.println("_____Такт работы магазина_____");
            Customer customer = createCustomer();
            customer.chooseCash(cashList);
            getInfo();
            startCash();
            setisJustComeIn();
            countTakts--;
        }
    }

    private void getInfo() {

        for (Cash cash : cashList) {
            System.out.println(cash.getInfo());
        }

    }

    public void setisJustComeIn() {
        for (Cash cash : cashList) {
            Deque<Customer> queue = cash.getQueue();
            for (Customer customer : queue
            ) {
                customer.setJustComeIn(false);
            }
        }
    }

    private void startCash() {
        for (Cash cash : cashList) {
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
        ArrayList<Customer> arrayListofCustomer = new ArrayList<>();
        int countCustomers = 3;
        int countPurchase = 10;
        arrayListofCustomer.add(new Child(new Random().nextInt(countPurchase) + 1));
        arrayListofCustomer.add(new Men(new Random().nextInt(countPurchase) + 1));
        arrayListofCustomer.add(new Woman(new Random().nextInt(countPurchase) + 1));
        Customer customer = arrayListofCustomer.get(new Random().nextInt(countCustomers));
        return customer;
    }

    static int getRandomSpeed() {
        return (new Random().nextInt(2) + 1);
    }
}

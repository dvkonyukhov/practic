package dz3.shop;

import java.util.*;

public class Shop {
    //private final String name;
    private final List<Cash> cashes = new ArrayList<>();

    private final CustomerFactory customerFactory;

    public Shop(int cashCount) {
        customerFactory = new CustomerFactory();
        for (int i = 1; i < cashCount + 1; i++) {
            Cash cash = new Cash(("cash" + i), getRandomSpeed());
            addCash(cash);
        }
    }

    public void addCash(Cash cash) {
        cashes.add(cash);
    }

    public void startProcess() {

        CreateCustomer();
        ServeCustomers();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void ServeCustomers() {
        Thread threadCash = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (cashes) {
                    for (Cash cash : cashes) {
                        cash.serveCustomer(0);
                        setJustComeIn();
                        System.out.println(cash.getInfo());
                    }
                }
            }
        });
        threadCash.start();
    }

    private void CreateCustomer() {

        Thread threadCustomer = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Customer customer = customerFactory.createCustomer();
                synchronized (cashes) {
                    System.out.println(customer.chooseCash(cashes).getInfo());
                }
            }
        });
        threadCustomer.start();
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

    static int getRandomSpeed() {
        return (new Random().nextInt(3) + 1);
    }
}

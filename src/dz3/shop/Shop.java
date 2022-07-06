package dz3.shop;

import java.util.*;

public class Shop {
    //private final String name;
    private final List<Cash> cashes = new ArrayList<>();
    private final int iterationCount;
    private final CustomerFactory customerFactory;

    public Shop(int iterationCount, int cashCount) {
        this.iterationCount = iterationCount;
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

        CreateCustomer(iterationCount);
        ServeCustomers(iterationCount);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void ServeCustomers() {
        while (true) {
            Thread threadCash = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (cashes) {
                        startCash();
                    }
                    setJustComeIn();
                }
            });
            threadCash.start();
        }
    }

    private void CreateCustomer(int iterationCountForCustomer) {

        while (iterationCountForCustomer > 0) {
            Thread threadCustomer = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Customer customer = customerFactory.createCustomer();
                synchronized (cashes) {
                    customer.chooseCash(cashes);
                }
                printInfo();
            });
            threadCustomer.start();
            iterationCountForCustomer--;
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

    static int getRandomSpeed() {
        return (new Random().nextInt(3) + 1);
    }
}

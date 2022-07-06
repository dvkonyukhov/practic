package dz3.shop;

import java.util.Random;

public class CustomerFactory {

    public Customer createCustomer() {

        int countCustomers = 2;
        int maxCountPurchase = 5;
        int customerNumber = new Random().nextInt(countCustomers);

        Customer newCustomer = null;

        switch (customerNumber) {
            case 0 -> newCustomer = new Child(new Random().nextInt(maxCountPurchase) + 1);
            case 1 -> newCustomer = new Man(new Random().nextInt(maxCountPurchase) + 1);
            case 2 -> newCustomer = new Woman(new Random().nextInt(maxCountPurchase) + 1);
        }
        return newCustomer;
    }
}

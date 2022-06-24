package dz3.shop;

import java.util.*;

public class Cash {
    private final String name;
    private int speed;
    private Deque<Customer> queue = new LinkedList<>();

    public Cash(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public void serveCustomer() {
        Customer currentCustomer = queue.peek();
        if (currentCustomer == null) {
            return;
        }
        int countPurchase = currentCustomer.getPurchaseCount() - getSpeed();
        if (countPurchase >= 0) {
            System.out.println(getName() + " обслужила покупателя: " + currentCustomer.getInfo() + " Количество покупок осталось: " + countPurchase);
            if (countPurchase == 0) {
                deleteCurrentCustomer();
            } else {
                currentCustomer.changePurchaseCount(countPurchase);
            }
            return;
        } else {
            System.out.println(getName() + " обслужила покупателя: " + currentCustomer.getInfo() + " Количество покупок осталось: " + 0);
            currentCustomer.changePurchaseCount(0);
            deleteCurrentCustomer();
            serveCustomer();
        }

    }

    public String getInfo() {
        StringBuilder builder = new StringBuilder(getName() + " очередь: ");
        for (Customer customer : queue) {
            builder.append(" " + customer.getInfo());
        }
        return builder.toString();
    }

    public String getName() {
        return "Касса " + name + " (" + getSpeed() + ")";
    }

    public void deleteCurrentCustomer() {
        queue.poll();
    }

    public int getSize() {
        return queue.size();
    }

    public void addCustomer(Customer customer) {
        queue.add(customer);
    }

    public int getSpeed() {
        return speed;
    }

    public Deque<Customer> getQueue() {
        return queue;
    }
}

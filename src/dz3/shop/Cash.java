package dz3.shop;

import java.util.*;

public class Cash {
    private final String NAME;
    private final int speed;
    private final Queue<Customer> queue = new LinkedList<>();

    public Cash(String NAME, int speed) {
        this.NAME = NAME;
        this.speed = speed;
    }

    public void serveCustomer() {
        Customer currentCustomer = queue.peek();
        if (currentCustomer == null) {
            return;
        }
        int countPurchase = currentCustomer.getPurchaseCount() - getSpeed();
        if (countPurchase >= 0) {
            System.out.println(getNAME() + " обслужила покупателя: " + currentCustomer.getInfo() + " Количество покупок осталось: " + countPurchase);
            if (countPurchase == 0) {
                deleteCurrentCustomer();
            } else {
                currentCustomer.changePurchaseCount(countPurchase);
            }
        } else {
            System.out.println(getNAME() + " обслужила покупателя: " + currentCustomer.getInfo() + " Количество покупок осталось: " + 0);
            currentCustomer.changePurchaseCount(0);
            deleteCurrentCustomer();
            serveCustomer();
        }

    }

    public String getInfo() {
        StringBuilder builder = new StringBuilder(getNAME() + " очередь: ");
        for (Customer customer : queue) builder.append(" ").append(customer.getInfo());
        return builder.toString();
    }

    public String getNAME() {
        return "Касса " + NAME + " (" + getSpeed() + ")";
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

    public Queue<Customer> getQueue() {
        return queue;
    }

}

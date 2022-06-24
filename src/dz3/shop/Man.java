package dz3.shop;

import java.util.Deque;
import java.util.List;

public class Man extends Customer {
    @Override
    void chooseCash(List<Cash> cashList) {
        Cash currentCash = cashList.get(0);
        double currentSize = getTaktSizeOfQueque(currentCash);
        for (int i = 1; i < cashList.size(); i++) {
            Cash cash = cashList.get(i);
            double TaktSizeOfQueque = getTaktSizeOfQueque(cash);
            if (TaktSizeOfQueque < currentSize) {
                currentCash = cash;
                currentSize = TaktSizeOfQueque;
            }
        }
        currentCash.addCustomer(this);
    }

    public Man(int purchaseCount) {
        super(purchaseCount);
    }

    public String getInfo() {
        return (getClass().getSimpleName() + "(" + getPurchaseCount() + ")" + isJustComeIn());
    }

    private double getTaktSizeOfQueque(Cash cash) {
        Deque<Customer> deque = cash.getQueue();
        if (cash.getSize() == 0) {
            return 0;
        } else {
            int purchaseCount = 0;
            for (Customer customer : deque
            ) {
                purchaseCount = purchaseCount + customer.getPurchaseCount();
            }
            return purchaseCount / cash.getSpeed();
        }

    }

}

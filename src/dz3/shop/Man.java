package dz3.shop;

import java.util.List;
import java.util.Queue;

public class Man extends Customer {
    @Override
    void chooseCash(List<Cash> cashList) {
        Cash currentCash = cashList.get(0);
        double currentSpeedCash = getSpeedCash(currentCash);
        for (int i = 1; i < cashList.size(); i++) {
            Cash cash = cashList.get(i);
            double speedCash = getSpeedCash(cash);
            if (speedCash < currentSpeedCash) {
                currentCash = cash;
                currentSpeedCash = speedCash;
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

    private double getSpeedCash(Cash cash) {
        Queue<Customer> deque = cash.getQueue();
        if (cash.getSize() == 0) {
            return 0;
        } else {
            double purchaseCount = 0;
            for (Customer customer : deque
            ) {
                purchaseCount = purchaseCount + customer.getPurchaseCount();
            }
            return purchaseCount / cash.getSpeed();
        }

    }

}

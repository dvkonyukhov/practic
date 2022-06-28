package dz3.shop;

import java.util.List;

public class Man extends Customer {
    @Override
    void chooseCash(List<Cash> cashes) {
        Cash currentCash = cashes.get(0);
        double currentSpeedCash = currentCash.getSpeedCash();
        for (int i = 1; i < cashes.size(); i++) {
            Cash cash = cashes.get(i);
            double speedCash = cash.getSpeedCash();
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

}

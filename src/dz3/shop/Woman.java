package dz3.shop;

import java.util.List;
import java.util.Random;

public class Woman extends Customer {
    @Override
    void chooseCash(List<Cash> cashList) {
        Cash currentCash = cashList.get(0);
        for (int i = 1; i < cashList.size(); i++) {
            Cash cash = cashList.get(i);
            if (cash.getSize() < currentCash.getSize()) {
                currentCash = cash;
            }
        }
        currentCash.addCustomer(this);
    }

    public Woman(int purchaseCount) {
        super(purchaseCount);
    }

    public String getInfo() {
        return (getClass().getSimpleName() + "(" + getPurchaseCount() + ")" + isJustComeIn());
    }
}

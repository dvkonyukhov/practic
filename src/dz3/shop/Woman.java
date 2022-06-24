package dz3.shop;

import java.util.List;

public class Woman extends Customer {
    @Override
    void chooseCash(List<Cash> cashes) {
        Cash currentCash = cashes.get(0);
        for (int i = 1; i < cashes.size(); i++) {
            Cash cash = cashes.get(i);
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

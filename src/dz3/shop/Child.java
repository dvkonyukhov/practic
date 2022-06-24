package dz3.shop;

import java.util.List;
import java.util.Random;

public class Child extends Customer {

    @Override
    void chooseCash(List<Cash> cashes) {
        Cash cash = cashes.get(new Random().nextInt(cashes.size()));
        cash.addCustomer(this);
    }

    public Child(int purchaseCount) {
        super(purchaseCount);
    }

    public String getInfo() {
        return (getClass().getSimpleName() + "(" + getPurchaseCount() + ")" + isJustComeIn());
    }
}

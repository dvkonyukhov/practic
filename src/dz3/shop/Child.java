package dz3.shop;

import java.util.List;
import java.util.Random;

public class Child extends Customer {

    @Override
    void chooseCash(List<Cash> cashList) {
        Cash cash = cashList.get(new Random().nextInt(cashList.size()));
        cash.addCustomer(this);
    }

    public Child(int purchaseCount) {
        super(purchaseCount);
    }

    public String getInfo() {
        return (getClass().getSimpleName() + "(" + getPurchaseCount() + ")" + isJustComeIn());
    }
}

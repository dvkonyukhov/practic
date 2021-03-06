package dz3.shop;

import java.util.List;

abstract public class Customer {
    private int purchaseCount;
    protected boolean isJustComeIn;

    abstract Cash chooseCash(List<Cash> cashes);

    abstract String getInfo();

    public Customer(int purchaseCount) {
        this.purchaseCount = purchaseCount;
        this.isJustComeIn = true;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public void setJustComeIn(boolean justComeIn) {
        isJustComeIn = justComeIn;
    }

    public void changePurchaseCount(int count) {
        purchaseCount = count;
    }

    public String isJustComeIn() {
        if (isJustComeIn)
            return "(new)";
        else
            return "";
    }
}

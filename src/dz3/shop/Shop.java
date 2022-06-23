package dz3.shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private String name;
    private List<Cash> cashList = new ArrayList();
    private List<Customer> customers = new ArrayList();
    private int takt;

    public Shop(String name, int takt) {
        this.name = name;
        this.takt = takt;
    }

    public void addCash(Cash cash){
        cashList.add(cash);
    }
}

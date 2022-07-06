package dz3.shop;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop(IO.getCashCount());
        shop.startProcess();
    }
}

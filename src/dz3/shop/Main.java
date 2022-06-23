package dz3.shop;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int countCustomers = entercountCustomers();

        Shop shop = new Shop("shop1", 100);
        createCash(shop);

    }

    static int entercountCustomers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество покупателей...");
        return scanner.nextInt();
    }

    static void createCash(Shop shop) {
        Cash cash1 = new Cash("cash1", getRandomSpeed());
        Cash cash2 = new Cash("cash2", getRandomSpeed());
        Cash cash3 = new Cash("cash3", getRandomSpeed());
        Cash cash4 = new Cash("cash4", getRandomSpeed());
    }

    static int getRandomSpeed() {
        return (new Random().nextInt(2) + 1);
    }
}

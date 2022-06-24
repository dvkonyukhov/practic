package dz3.shop;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int countTakts = entercountCustomers();
        int countCash = entercountCash();

        Shop shop = new Shop("shop1", countTakts, countCash);
        shop.startProcess();
    }

    static int entercountCustomers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество тактов работы:");
        return scanner.nextInt();
    }

    static int entercountCash() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество касс:");
        return scanner.nextInt();
    }

}

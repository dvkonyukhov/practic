package dz3.shop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int iterationCount = countCustomers();
        int cashCount = countCash();

        Shop shop = new Shop(iterationCount, cashCount);
        shop.startProcess();
    }

    static int countCustomers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество тактов работы:");
        return scanner.nextInt();
    }

    static int countCash() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество касс:");
        return scanner.nextInt();
    }

}

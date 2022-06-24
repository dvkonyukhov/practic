package dz3.shop;

import java.util.Scanner;

public class IO {

    static int getCustomersCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество тактов работы:");
        return scanner.nextInt();
    }

    static int getCashCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество касс:");
        return scanner.nextInt();
    }
}

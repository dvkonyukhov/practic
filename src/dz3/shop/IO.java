package dz3.shop;

import java.util.Scanner;

public class IO {

    static int getCashCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество касс:");
        return scanner.nextInt();
    }
}

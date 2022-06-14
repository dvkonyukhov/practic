package dz2.static_test;

public class StaticTest {
    public static void main(String[] args) {
        System.out.println("Статичное поле (обращение через класс): " + InfoStatic.date);
        System.out.println("Статичное поле (обращение через объект): " + new InfoStatic().date);
        System.out.println("Статичный метод (обращение через класс): " + InfoStatic.getfreeMemory());
    }
}

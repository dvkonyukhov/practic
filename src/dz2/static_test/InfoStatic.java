package dz2.static_test;

import java.util.Date;

public class InfoStatic {
    public static Date date = new Date();
    public static String name;
    public String nameNonStatic;

    static {
        System.out.println("Инициализация статичного блока");
        // нельзя обратиться к нестатичному полю из статичного блока
        //System.out.println("Значение нестатичной переменной = " + nameNonStatic);
        name = "Статичное поле";
    }
    public InfoStatic() {
        // можно обратиться к статичному полю из конструктова
        System.out.println("Значение нестатичной переменной = " + nameNonStatic);
        System.out.println("Инициализация констурктора");
    }

    public static Long getfreeMemory(){
        // нельзя обратиться к нестатичному полю из статичного блока
        //System.out.println("Значение нестатичной переменной = " + nameNonStatic);
        System.out.println("Инициализация статичного метода");
        return Runtime.getRuntime().freeMemory();
    }
}

package dz3.string;

import java.util.Locale;

public class StringTest {
    public static void main(String[] args) {

        String name1 = new String("Ivan");
        String name2 = "Ivan";

        System.out.println("Сравнение по значению:");
        checkStringsEquals(name1, name2);
        System.out.println("Сравнение по ссылке:");
        checkStrings(name1, name2);

        //Поместим в пул строк
        name1 = name1.intern();

        System.out.println("Сравнение по ссылке после помещения в пул строк:");
        checkStrings(name1, name2);

        String test = "   test1test2  ll        ";
        System.out.println(test.trim());
        System.out.println(test.toUpperCase(Locale.ROOT));
        System.out.println(String.valueOf(192929229L).length());
        System.out.println(name1.charAt(2));
        System.out.println(name1.concat(name2));
        System.out.println(String.join("_", name1, name2));
        checkSpeedString();
        checkSpeedStringBuilder();

    }

    static void checkStringsEquals(String string1, String string2) {
        if (string1.equals(string2))
            System.out.println("Строки равны");
        else
            System.out.println("Строки не равны");
    }

    static void checkStrings(String string1, String string2) {
        if (string1 == string2)
            System.out.println("Строки равны");
        else
            System.out.println("Строки не равны");
    }

    static void checkSpeedString() {
        long start = System.currentTimeMillis();
        String string = "";
        for (int i = 0; i < 1_000_00; i++) {
            string = string + i;
        }
        long end = System.currentTimeMillis();
        System.out.println("String time:" + (end - start));
    }


    static void checkSpeedStringBuilder() {
        long start = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1_000_00; i++) {
            stringBuilder.append(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder time:" + (end - start));
    }
}

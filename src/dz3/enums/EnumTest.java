package dz3.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnumTest {
    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Mihail", Sex.MALE, Eyes.BLUE));
        personList.add(new Person("Pavel", Sex.MALE, Eyes.GREEN));
        personList.add(new Person("Olga", Sex.FEMALE, Eyes.BROWN));

        for (Person person : personList) {
            System.out.println(person);
        }

        System.out.println(Eyes.valueOf("GREEN"));
        System.out.println(Arrays.toString(Eyes.values()));
        System.out.println(Sex.MALE.name());
        System.out.println(Sex.FEMALE.ordinal());

    }
}

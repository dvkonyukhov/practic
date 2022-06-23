package dz3.anonymous;

import dz3.enums.Eyes;
import dz3.enums.Person;
import dz3.enums.Sex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnonymousTest {
    public static void main(String[] args) {

        // анонимный класс для запуска потока
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Run...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Stop...");
            }
        });

        thread.start();

        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Mihail", Sex.MALE, Eyes.BLUE));
        personList.add(new Person("Pavel", Sex.MALE, Eyes.GREEN));
        personList.add(new Person("Olga", Sex.FEMALE, Eyes.BROWN));

        for (Person person : personList) {
            System.out.println(person);
        }

        // анонимный класс для сортировки
        personList.sort(new Comparator<>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println("Sort:");
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}

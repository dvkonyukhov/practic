package dz2.params;

public class ParamsTest {
    public static void main(String[] args) {
        int i = 10;
        String s = "test";
        Person person = new Person("Alexandr",  40);
        checkParams(person, i, s);
        System.out.println(person);
        System.out.println(i);
        System.out.println(s);
    }

    static void checkParams(Person p, int i, String s){
        i = 0;
        s = "";
        p.setAge(30);
        p = null;
    }
}

package dz2.privateclass;

class NonPrivateClass {

    private class PrivateClass {
        public void test() {
            System.out.println("Метод приватного класса");
        }
    }

    void test() {
        System.out.println("Метод внешнего класса");
        PrivateClass privateClass = new PrivateClass();
        privateClass.test();
    }
}

public class PrivateTest {

    public static void main(String[] args) {
        NonPrivateClass nonPrivateClass = new NonPrivateClass();
        nonPrivateClass.test();
    }
}
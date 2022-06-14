package dz2.privateclass;

class NonPrivateClass {

    private class PrivateClass {
        public void test() {
            System.out.println("����� ���������� ������");
        }
    }

    void test() {
        System.out.println("����� �������� ������");
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
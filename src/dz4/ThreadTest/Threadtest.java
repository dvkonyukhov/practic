package dz4.ThreadTest;

public class Threadtest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread1());
        Thread2 thread3 = new Thread2();
        thread1.start();
        thread2.start();
        thread3.start();

        thread3.join();

        System.out.println("end main");
    }
}

class Thread1 implements Runnable {

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                Thread.yield();
            }
        }
    }
}

class Thread2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "!!!!!!!!" + i);
        }
    }
}

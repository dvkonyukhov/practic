package dz4.waitnotify;

public class WaitNotifyTest {

    public static void main(String[] args) throws InterruptedException {
        Message msg = new Message("обработать");
        Waiter waiter = new Waiter(msg);
        new Thread(waiter, "waiter1").start();

        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter2").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier1").start();

        Thread.sleep(4000);
        Notifier notifier1 = new Notifier(msg);
        new Thread(notifier, "notifier2").start();
    }

}

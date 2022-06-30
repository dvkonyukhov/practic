package dz4.waitnotify;

public class Waiter implements Runnable {

    private final Message msg;

    public Waiter(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try {
                System.out.println(name + " ждем вызов метода notify...");
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " был вызов метода notify...");
            System.out.println(name + " : " + msg.getMsg());
        }
    }
}

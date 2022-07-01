package dz4.box;

public class ConsumerBox implements Runnable{
    private final Box box;

    @Override
    public void run() {

        while (true) {
            synchronized (box) {
                if (!box.isValue()) {
                    try {
                        box.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int i = box.getValue();
                if (i == -1) {
                    box.notify();
                    break;
                }
                box.setValue(0);
                box.setIsValue(false);
                System.out.println("C(" + i + ")");
                box.notify();
            }
        }

    }

    public ConsumerBox(Box box) {
        this.box = box;
    }
}

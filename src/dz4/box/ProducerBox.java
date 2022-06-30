package dz4.box;

import java.util.Random;

public class ProducerBox extends Thread {
    private final Box box;

    @Override
    public void run() {

        int stepsCount = 10;

        while (stepsCount > 0) {
            synchronized (box) {
                if (box.isValue()) {
                    try {
                        box.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int i = new Random().nextInt(20);
                box.setValue(i);
                box.setIsValue(true);
                System.out.println("P(" + i + ")");
                stepsCount--;
                box.notify();
            }
        }

        synchronized (box){
            if (box.isValue()) {
                try {
                    box.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            box.setValue(-1);
            box.setIsValue(true);
            box.notify();
        }
    }

    public ProducerBox(Box box) {
        this.box = box;
    }
}

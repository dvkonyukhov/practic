package dz4.box;

public class BoxTest {
    public static void main(String[] args) {
        Box box = new Box();
        Thread producerBox = new Thread(new ProducerBox(box));
        Thread consumerBox = new Thread(new ConsumerBox(box));
        producerBox.start();
        consumerBox.start();
    }
}

package dz4.box;

public class BoxTest {
    public static void main(String[] args) {
        Box box = new Box();
        Thread producerBox = new ProducerBox(box);
        ConsumerBox consumerBox = new ConsumerBox(box);
        producerBox.start();
        consumerBox.start();
    }
}

package dz3.shop;

import java.util.LinkedList;
import java.util.Queue;

public class Cash {
    private final String name;
    private int speed;
    private Queue queue = new LinkedList();

    public Cash(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}

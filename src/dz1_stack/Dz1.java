package dz1_stack;

import java.awt.*;
import java.util.Date;

public class Dz1 {
    public static void main(String[] args) {
        Stack<Object> stack = new Stack<>();

        stack.push(1);
        stack.push("test1");
        stack.push("test2");
        stack.push(Integer.parseInt("10"));
        stack.push(new Date());
        stack.push(Runtime.getRuntime().availableProcessors());
        stack.push(SystemColor.RED);
        stack.push(2);
        stack.push("test12");
        stack.push("test22");

        int size = stack.getSize();

        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }
    }
}

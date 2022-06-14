package dz2.astractinterface;

public class AbstractTest {
    public static void main(String[] args) {
        Chair chair = new Chair("stul1");
        chair.setColor(Colors.BLUE);
        chair.changeColor(Colors.GREEN);
        chair.changePrice(100);
        Table table = new Table("stol1");
        table.setColor(Colors.RED);
        table.setComment("comment");
        System.out.println(chair);
        System.out.println(table);
    }
}

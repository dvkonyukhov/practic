package dz2.astractinterface;

public class Table extends Mebel {
    private String comment;
    public Table(String name) {
        super(name);
    }

    @Override
    void getColor() {
        color = Colors.RED;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Table{" +
                "color=" + color +
                ", name=" + getName() +
                ", comment='" + comment + '\'' +
                '}';
    }
}

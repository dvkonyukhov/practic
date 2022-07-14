package dz3.enums;

public enum Eyes {
    GREEN("Zelenye", 2), BROWN("Karie", 6), BLUE("Golubie", 1);
    private transient String comment;
    private transient int id;

    Eyes(String comment, int id) {
        this.comment = comment;
        this.id = id;
        System.out.println("сработал конструктор");
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "Eyes{" +
                "comment='" + comment + '\'' +
                ", id=" + id +
                '}';
    }
}

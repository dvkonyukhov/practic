package dz3.enums;

public enum Eyes {
    GREEN("Зеленые", 2), BROWN("Карие", 6), BLUE("Голубые", 1);
    private transient String comment;
    private transient int id;

    Eyes(String comment, int id) {
        this.comment = comment;
        this.id = id;
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

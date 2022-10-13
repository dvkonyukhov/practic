package dz6;

public class Document implements Cloneable {
    String name;

    public Document(String name) {
        this.name = name;
    }

    @Override
    protected Document clone() throws CloneNotSupportedException {
        return (Document) super.clone();
    }
}

package dz2.astractinterface;

abstract public class Mebel {
    private final String name;
    Colors color;
    abstract void getColor();

    public void setColor(Colors color) {
        this.color = color;
    }

    public Mebel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Mebel{" +
                "name='" + name + '\'' +
                ", color=" + color +
                '}';
    }
}

package dz2.astractinterface;

public class Chair extends Mebel implements ColorAble{
    public Chair(String name) {
        super(name);
    }

    @Override
    void getColor() {

    }

    @Override
    public void changeColor(Colors newColor) {
        this.color = newColor;
    }
}

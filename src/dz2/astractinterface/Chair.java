package dz2.astractinterface;

public class Chair extends Mebel implements ColorAble, PriceAble{
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

    @Override
    public void changePrice(int price) {
        this.price = price;
    }
}

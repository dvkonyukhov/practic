package dz2.modifier;

public class Modifier {
    public String name;
    String nameDefaul;
    private String namePrivate;
    protected String nameProtected;

    public Modifier(String name, String nameDefaul, String namePrivate, String nameProtected) {
        this.name = name;
        this.nameDefaul = nameDefaul;
        this.namePrivate = namePrivate;
        this.nameProtected = nameProtected;
    }

}

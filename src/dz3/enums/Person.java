package dz3.enums;

public class Person{
    private String name;
    private Sex sex;
    private Eyes eyes;

    public Person(String name, Sex sex, Eyes eyes) {
        this.name = name;
        this.sex = sex;
        this.eyes = eyes;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", eyes=" + eyes +
                "(" + eyes.getComment() +
                ")}";
    }

    public String getName() {
        return name;
    }
}

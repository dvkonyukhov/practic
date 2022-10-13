package dz6;

public class Person implements Cloneable {
    int age;
    String name;
    Document document;

    public void setName(String name) {
        this.name = name;
    }

    public Person(int age, String name, Document document) {
        this.age = age;
        this.name = name;
        this.document = document;
    }


    public Document getDocument() {
        return document;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        Person person =  (Person) super.clone();
        person.document = person.document.clone();
        return person;
    }

}

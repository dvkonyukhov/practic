package dz6;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Document document = new Document("passport");
        Person person = new Person(22, "Ivan", document);
        System.out.println(person);
        Person clonePerson = person.clone();
        System.out.println(clonePerson);
        System.out.println(clonePerson.equals(person));
        System.out.println(clonePerson.getDocument());
        System.out.println(person.getDocument());
        System.out.println(clonePerson.getDocument() == person.getDocument());
    }
}
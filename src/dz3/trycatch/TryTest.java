package dz3.trycatch;

import dz3.enums.Eyes;

import java.io.*;

public class TryTest {
    public static void main(String[] args) {
        try {
            testTryCatch();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static public void testTryCatch() throws FileNotFoundException{

        // Enum поддерживает сериализацию
        FileOutputStream fileOutputStream = new FileOutputStream("emunSerialize.txt");

        //try with resources
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(Eyes.BROWN);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //нет смысла
        //objectOutputStream.close();

        // Странное поведение, поля comment и id помечены как transient, но все равно попадают в файл
        try (FileInputStream fileInputStream = new FileInputStream("emunSerialize.txt")) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            System.out.println(objectInputStream.readObject().toString());
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

package dz4.files;

import java.io.*;

public class FileTest {
    public static void main(String[] args) {

        File file = testCreateFile();
        testWriter(file);
        testReader(file);
        testOutput(file);
        testInput(file);
    }

    private static void testInput(File file) {
        System.out.println("Чтение через fileInputStream:");
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int i = -1;
            while ((i = fileInputStream.read()) != -1) {
                System.out.print((char) i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testOutput(File file) {
        System.out.println("Запись через FileOutputStream");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            String data = "Test data";
            fileOutputStream.write(data.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testWriter(File file) {

        System.out.println("Запись через FileWriter");
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("fileWriter1 txt" + System.lineSeparator());
            fileWriter.append('3');
            fileWriter.write("fileWriter2 txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testReader(File file) {

        System.out.println("Чтение через FileReader:");
        try (FileReader fileReader = new FileReader(file)) {
            int charCode;
            while ((charCode = fileReader.read()) != -1) {
                System.out.print((char) charCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(System.lineSeparator());
    }

    private static File testCreateFile() {
        File file = new File("test.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Файл создан");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Файл уже существует");
            //System.out.println(file.getName());
            //System.out.println(file.getAbsoluteFile());
        }
        return file;
    }

}

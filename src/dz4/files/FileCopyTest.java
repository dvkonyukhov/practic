package dz4.files;

import dz4.waitnotify.Message;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileCopyTest {
    public static void main(String[] args) {

        System.out.println("Введите имя файла источника");
        Scanner scanner = new Scanner(System.in);
        File file = createFile(scanner.nextLine());
        writeText(file);
        System.out.println("Введите имя файла приемника");
        copyFile(file, scanner.nextLine());
        System.out.println("Основной поток завершил работу");
        System.out.println("Для прерывания копирования файла введите команду: stop");
    }

    private static File createFile(String fileSourceName) {

        File file = new File(fileSourceName);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    private static void writeText(File file) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            StringBuffer stringBuffer = new StringBuffer();

            for (int i = 0; i < 15; i++) {
                stringBuffer.append(i);
            }

            fileOutputStream.write(stringBuffer.toString().getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile(File file, String fileDestName) {

        Message message = new Message("start");

        Thread threadCopy = new Thread(new Runnable() {
            @Override
            public void run() {

                File fileDest = new File(fileDestName);

                try (FileInputStream fileInputStream = new FileInputStream(file);
                     FileOutputStream fileOutputStream = new FileOutputStream(fileDest)) {

                    int sizeOfBuffer = 5;
                    int length;
                    byte[] buffer = new byte[sizeOfBuffer];
                    long lengthOfSourceFile = file.length();
                    long step = 0;
                    while ((length = fileInputStream.read(buffer)) > 0) {
                        fileOutputStream.write(buffer, 0, length);
                        step = step + sizeOfBuffer;
                        System.out.println("Скопировано: " + (int) ((double) step / (double) lengthOfSourceFile * 100) + " процентов");
                        Thread.sleep(4000);
                        synchronized (message) {
                            if (message.getMsg().equals("stop")) {
                                System.out.println("Копирование прервано пользователем");
                                fileOutputStream.close();
                                fileDest.delete();
                                break;
                            }
                        }
                    }
                    message.setMsg("stop");

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread threadListenerInput = new Thread(new Runnable() {
            @Override
            public void run() {
                String commandStop = "stop";
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    String textUser = scanner.nextLine();
                    synchronized (message) {
                        if (textUser.equals(commandStop) || message.getMsg().equals(commandStop)) {
                            message.setMsg(textUser);
                        }
                        {
                            break;
                        }
                    }
                }
            }
        });

        threadCopy.start();
        threadListenerInput.start();
    }
}

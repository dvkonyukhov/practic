package dz5.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket implements Runnable {
    private Server server;
    private PrintWriter outMessage;
    private BufferedReader inMessage;
    private static int clientsCount = 0;
    private Socket socket;

    public ClientSocket(Socket socket, Server server) {
        try {
            clientsCount++;
            this.server = server;
            this.outMessage = new PrintWriter(socket.getOutputStream());
            this.inMessage = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.socket = socket;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {

        server.sendMessageToAllClients("Новый участник вошёл в чат!", this);
        server.sendMessageToAllClients("Клиентов в чате = " + clientsCount, this);

        String data;
        while (true) {
            try {
                if ((data = inMessage.readLine()) != null) {

                    if (data.equalsIgnoreCase("end")) {
                        break;
                    }
                    System.out.println(data);
                    server.sendMessageToAllClients(data, this);
                } else {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
        close();
        System.out.println("Сокет" + socket + "закрыл соединение");
    }

    public void sendMsg(String msg) {
        try {
            outMessage.println(msg);
            outMessage.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void close() {
        server.removeClient(this);
        clientsCount--;
        server.sendMessageToAllClients("Клиентов в чате = " + clientsCount, null);
    }
}

package dz5.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static final int PORT = 2345;
    private final ArrayList<ClientSocket> clients = new ArrayList<>();

    public Server() {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Старт Сервера!");

        while (true) {
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ClientSocket client = new ClientSocket(clientSocket, this);
            clients.add(client);
            new Thread(client).start();
        }

    }

    public void sendMessageToAllClients(String msg) {
        for (ClientSocket o : clients) {
            o.sendMsg(msg);
        }

    }

    public void removeClient(ClientSocket client) {
        clients.remove(client);
    }

}
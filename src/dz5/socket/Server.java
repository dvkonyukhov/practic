package dz5.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static final int PORT = 2345;
    private final ArrayList<ClientSocket> clients = new ArrayList<>();

    public Server() {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void sendMessageToAllClients(String msg, ClientSocket currentClientSocket) {
        for (ClientSocket clientSocket : clients) {
            if (clientSocket != currentClientSocket)
                clientSocket.sendMsg(msg);
        }

    }

    public void removeClient(ClientSocket client) {
        clients.remove(client);
    }

}
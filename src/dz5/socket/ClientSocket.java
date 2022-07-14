package dz5.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket implements Runnable {
    private Server server;
    private PrintWriter outMessage;
    private Scanner inMessage;
    private static int clientsCount = 0;

    public ClientSocket(Socket socket, Server server) {
        try {
            clientsCount++;
            this.server = server;
            this.outMessage = new PrintWriter(socket.getOutputStream());
            this.inMessage = new Scanner(socket.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        server.sendMessageToAllClients("Новый участник вошёл в чат!");
        server.sendMessageToAllClients("Клиентов в чате = " + clientsCount);

        while (true) {
            if (inMessage.hasNext()) {
                String clientMessage = inMessage.nextLine();

                if (clientMessage.equalsIgnoreCase("end")) {
                    break;
                }
                System.out.println(clientMessage);
                server.sendMessageToAllClients(clientMessage);
            }
        }
        close();
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
        server.sendMessageToAllClients("Клиентов в чате = " + clientsCount);
    }
}

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
    private Socket socket;

    public ClientSocket(Socket socket, Server server) {
        try {
            clientsCount++;
            this.server = server;
            this.outMessage = new PrintWriter(socket.getOutputStream());
            this.inMessage = new Scanner(socket.getInputStream());
            this.socket = socket;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        server.sendMessageToAllClients("Новый участник вошёл в чат!", this);
        server.sendMessageToAllClients("Клиентов в чате = " + clientsCount, this);

        while (true) {
//            if (socket.isClosed()) {
//                close();
//                break;
//            }
            if (inMessage.hasNext()) {
                String clientMessage = inMessage.nextLine();

                if (clientMessage.equalsIgnoreCase("end")) {
                    break;
                }
                System.out.println(clientMessage);
                server.sendMessageToAllClients(clientMessage, this);
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
        server.sendMessageToAllClients("Клиентов в чате = " + clientsCount, null);
    }
}

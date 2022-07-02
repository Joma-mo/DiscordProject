package services;

import control.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    /**
     * server constructor.
     * @param serverSocket while socket is not closed, accepts sockets from clients.\
     * Throws IOException.
     */
    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        while (!serverSocket.isClosed()) {
            try {
                Socket socket1 = serverSocket.accept();
                System.out.println("new client Connected");
                ClientHandler clientHandler = new ClientHandler(socket1);
                new Thread(clientHandler).start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket socket1 = new ServerSocket(2020);
        new Server(socket1);
    }
}

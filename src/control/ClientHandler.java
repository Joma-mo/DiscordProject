package control;

import org.json.JSONObject;
import responds.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    private Socket socket;
    private static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private DataInputStream input;
    private DataOutputStream output;
    private String userName;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            output = new DataOutputStream(socket.getOutputStream());
            input = new DataInputStream(socket.getInputStream());
            this.userName = input.readUTF();
            clientHandlers.add(this);
            System.out.println(userName);
            sendMessage("Server: " + userName + "  is Connected to chat!");
        } catch (IOException e) {
            CLoseSocket();
        }
    }


    private void CLoseSocket() {
        try {
            if (socket != null)
                socket.close();
            if (input != null)
                input.close();
            if (output != null)
                output.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void sendMessage(String message) {
        for (ClientHandler clientHandler : clientHandlers) {
            if (!clientHandler.userName.equals(this.userName)) {
                try {
                    clientHandler.output.writeUTF(message);
                } catch (IOException e) {
                    CLoseSocket();
                }
           }
        }
    }

    public void sendMessage(String message, String userName) {
        for(ClientHandler clientHandler : clientHandlers) {
            if (clientHandler.userName.equals(userName)) {
                try {
                    clientHandler.output.writeUTF(message);
                }
                catch (IOException e) {
                    CLoseSocket();
                }
            }
        }
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public void run() {
        while (socket.isConnected()) {
            try {
                String message = input.readUTF();
               JSONObject json = new JSONObject(message);
                RespondHandler handler = null;
                switch (json.getString("method")) {
                    case "logIn":
                        handler = new LogInRespondHandler(json, this);
                        break;
                    case "SignUp":
                        handler = new SignUpRespondHandler(json, this);
                        break;
                    case "FriendRequest":
                        handler = new FriendRequestHandler(json, this);
                        break;
                    case "message":
                        handler = new MessageHandler(json, this);
                        break;
                    default:
                        handler = new DoNothing(json, this);
                }
                handler.Handle();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

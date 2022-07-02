package control;

import org.json.JSONObject;
import responds.*;
import services.Message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

/**
 * class to handle the requests form clients, and reply to them.
 */
public class ClientHandler implements Runnable {
    private Socket socket;
    private static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private DataInputStream input;
    private DataOutputStream output;
    private String userName;

    /**
     * @param class constructor. Receives a socket.
     *        Throws an IOException
     */
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


    /**
     * close socket, input stream and output stream.
     */
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


    /**
     * @param message send the message to all clients except itself.
     *                Throws an IoException.
     */
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

    /**
     * @param message get the message to send for a client
     * @param userName get the username of client to send message for.
     *                 sending a message to a specific client.
     *                 Throws IOException.
     */
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

    /**
     * @return return username.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * while socket is connected, receives a request from client
     * and handle that specific request.
     * Throws IOException.
     */
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
                    case "signUp":
                        handler = new SignUpRespondHandler(json, this);
                        break;
                    case "friendRequest":
                        handler = new FriendRequestHandler(json, this);
                        break;
                    case "unFriend":
                        handler = new UnFriendHandler(json, this);
                        break;
                    case "blockedFriend":
                        handler = new BlockedFriendHandler(json, this);
                        break;
                    case "ShowFriends":
                        handler = new ShowFriendsHandler(json, this);
                        break;
                    case "ShowBlockedFriends":
                        handler = new ShowBlockedFriendsHandler(json, this);
                        break;
                    case "message":
                        handler = new MessageHandler(json, this);
                        break;
                    case "AddServer":
                        handler = new AddServerHandler(json, this);
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

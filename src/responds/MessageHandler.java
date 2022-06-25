package responds;

import control.ClientHandler;
import control.Data;
import org.json.JSONObject;
import services.Message;

import java.time.LocalDateTime;

public class MessageHandler extends RespondHandler{
    Data data;
    public MessageHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {
        Message message = new Message(client.getUserName(), json.getString("messageText"), LocalDateTime.now());
        //data.addMessage(client.getUserName(), message);
        client.sendMessage(message.toString(), json.getString("receiver"));
    }
}

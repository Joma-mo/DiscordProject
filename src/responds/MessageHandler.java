package responds;

import control.ClientHandler;
import org.json.JSONObject;

public class MessageHandler extends RespondHandler{
    public MessageHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {
        client.sendMessage(client.getUserName() + ": " + json.getString("messageText"));
    }
}

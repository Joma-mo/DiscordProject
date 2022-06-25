package responds;

import control.ClientHandler;
import control.Data;
import org.json.JSONObject;
import services.Message;

public class MessageHandler extends RespondHandler{
    Data data;
    public MessageHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {
        Message message = new Message(client.getUserName(), json.getString("messageText"));
        data.addMessage(data.findUser(client.getUserName()), message);
        client.sendMessage(message, client.getUserName());
    }
}

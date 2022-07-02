package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import org.json.JSONObject;
import services.Message;
import services.ObserverImp;

import java.time.LocalDateTime;

public class MessageHandler extends RespondHandler {
    public MessageHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {
        String receiver = json.getString("receiver");
        ObserverImp observer = new ObserverImp();
        Message message = new Message(client.getUserName(), json.getString("messageText"), LocalDateTime.now());
        try {
            observer.isBlocked(client.getUserName(), receiver);
        }
        catch (Exceptions exception) {
            parseErrorToJson(exception, "message");
        }
        parseMessageToJson(message.toString(), "message", receiver);
        data.addMessageToBox(observer.findCommonId(client.getUserName(), receiver), message);
    }
}

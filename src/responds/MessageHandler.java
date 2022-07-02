package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import org.json.JSONObject;
import services.Message;
import services.ObserverImp;

import java.time.LocalDateTime;

public class MessageHandler extends RespondHandler {
    /**
     * constructor.
     * @param json receives a JSONObject,
     * @param client receives a client handler.
     */
    public MessageHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    /**
     * receives the message and receiver of the message, and add the message.
     */
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

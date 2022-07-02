package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import org.json.JSONArray;
import org.json.JSONObject;
import services.Friend;
import services.Message;
import services.UserAccount;
import services.UserServer;

import java.util.HashMap;
import java.util.Map;

public class seeChatHistoryHandler extends RespondHandler{

    /**
     * constructor.
     * @param json receives a JSONObject,
     * @param client receives a client handler.
     */
    public seeChatHistoryHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    /**
     * receives the server name and channel name from JsonObject
     * parsing all messages to array and sending it to the client.
     * Throws Exceptions.
     */
    @Override
    public void Handle()  {
        String serverName = json.getString("serverName");
        UserServer server = data.findServer(serverName);

        String channelName = json.getString("channelName");
        int count = 0;
        JSONArray array = new JSONArray();
        for(Message message: server.getAllMessages(channelName)) {
            Map<String, String> map = new HashMap<>();
            map.put("nameOfSender", message.getNameOfSender());
            map.put("textMessage", message.getMessageText());
            map.put("dateTime", message.getDateTime().toString());
            array.put(count++, map);
        }
        try {
            parseJsonArrayToJson(client.getUserName());
        }
        catch (Exceptions exception){
            parseErrorToJson(exception, "seeChatHistory");
        }


    }
}

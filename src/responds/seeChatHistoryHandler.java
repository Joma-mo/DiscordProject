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
    public seeChatHistoryHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

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

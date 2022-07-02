package responds;

import control.ClientHandler;
import org.json.JSONObject;
import services.Message;
import services.UserAccount;
import services.UserServer;

import java.time.LocalDateTime;

public class GroupChatHandler extends RespondHandler{
    /**
     * constructor.
     * @param json receives a JSONObject,
     * @param client receives a client handler.
     */
    public GroupChatHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    /**
     * receives a server name and channel name from JSONObject,
     * adding message to the specific server.
     * sending message to all members of specific server.
     */
    @Override
    public void Handle() {
        String serverName = json.getString("serverName");
        UserServer server = data.findServer(serverName);

        String channelName = json.getString("channelName");
        Message message = new Message(client.getUserName(), json.getString("messageText"), LocalDateTime.now());
        server.addMessageToServer(message, channelName);
        for(UserAccount userAccount: server.getMembers()) {
            client.sendMessage(message.toString(), userAccount.getUserName());
        }
    }
}

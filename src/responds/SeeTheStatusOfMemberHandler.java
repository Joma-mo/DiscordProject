package responds;

import control.ClientHandler;
import org.json.JSONObject;
import services.Channel;
import services.UserAccount;
import services.UserServer;

public class SeeTheStatusOfMemberHandler extends RespondHandler{
    /**
     * constructor.
     * @param json receives a JSONObject,
     * @param client receives a client handler.
     */
    public SeeTheStatusOfMemberHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    /**
     * receives the server name from JsonObject,
     * sending the status of all members in a server to a client.
     */
    @Override
    public void Handle() {
        String serverName = json.getString("serverName");
        UserServer server = data.findServer(serverName);

        for (UserAccount user : server.getMembers()) {
            client.sendMessage(user.getUserName() + " is " + user.getStatus(), client.getUserName());
        }

    }
}

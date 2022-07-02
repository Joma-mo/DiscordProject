package responds;

import control.ClientHandler;
import org.json.JSONObject;
import services.Channel;
import services.UserAccount;
import services.UserServer;

public class SeeTheStatusOfMemberHandler extends RespondHandler{
    public SeeTheStatusOfMemberHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {
        String serverName = json.getString("serverName");
        UserServer server = data.findServer(serverName);

        for (UserAccount user : server.getMembers()) {
            client.sendMessage(user.getUserName() + " is " + user.getStatus(), client.getUserName());
        }

    }
}

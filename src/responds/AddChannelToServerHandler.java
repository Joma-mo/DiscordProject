package responds;

import control.ClientHandler;
import org.json.JSONObject;
import services.Channel;
import services.UserServer;

public class AddChanelToServerHandler extends RespondHandler{
    public AddChanelToServerHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {
//        String channelName = json.getString("channelName");
//        Channel channel = new Channel(channelName);
//        String serverName = json.getString("serverName");
//        UserServer server = data.findServer(serverName);
//        server.addChannelToServer(channel);
    }
}

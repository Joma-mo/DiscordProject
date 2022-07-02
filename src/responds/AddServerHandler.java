package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import org.json.JSONObject;
import services.ServerInterfaceImp;
import services.UserServer;

public class AddServerHandler extends RespondHandler{
    public AddServerHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {
        String serverName = json.getString("serverName");
        UserServer server = new UserServer(serverName, data.findUser(client.getUserName()));
        ServerInterfaceImp serverInterface = new ServerInterfaceImp();

        try {
            serverInterface.addServer(client.getUserName(), server);
            parseMessageToJson("server added successfully", "addServer");
        }
        catch (Exceptions exception) {
            parseErrorToJson(exception, "addServer");
        }
    }
}

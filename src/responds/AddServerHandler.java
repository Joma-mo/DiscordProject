package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import org.json.JSONObject;
import services.ServerInterfaceImp;
import services.UserServer;

public class AddServerHandler extends RespondHandler{
    /**
     * constructor
     * @param json receives a JSONObject,
     * @param client receives a client handler
     */
    public AddServerHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    /**
     * receives server name from JsonObject,
     * add server.
     * Throws Exceptions.
     */
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

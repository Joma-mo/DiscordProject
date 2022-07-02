package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import interfaces.ServerInterface;
import org.json.JSONObject;
import services.ServerInterfaceImp;

public class AddMemberToServerHandler extends RespondHandler{
    /**
     * constructor.
     * @param json receives a JSONObject
     * @param client receives a client handler
     */
    public AddMemberToServerHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    /**
     * receiving server name, maker of server and new member name from JsonObject
     * add member to the specified server.
     * Throws Exceptions.
     */
    @Override
    public void Handle() {
        String serverName = json.getString("serverName");
        String makerOfServer = json.getString("makerOfServer");
        String newMemberName = json.getString("newMemberName");

        ServerInterface serverInterface = new ServerInterfaceImp();
        try {
            serverInterface.addMemberToServer(serverName, makerOfServer, client.getUserName(), newMemberName);
            parseMessageToJson("Welcome to " + serverName + " server!", "addMemberToServer", newMemberName);
        }
        catch (Exceptions exception) {
            parseErrorToJson(exception, "addMemberToServer");
        }

    }
}

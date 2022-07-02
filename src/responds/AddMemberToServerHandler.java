package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import interfaces.ServerInterface;
import org.json.JSONObject;
import services.ServerInterfaceImp;

public class AddMemberToServerHandler extends RespondHandler{
    public AddMemberToServerHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

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

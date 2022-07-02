package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import interfaces.ServerInterface;
import org.json.JSONObject;
import services.ServerInterfaceImp;
import services.UserAccount;
import services.UserServer;

public class RemoveMemberFromServerHandler extends RespondHandler{
    public RemoveMemberFromServerHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {
        String serverName = json.getString("serverName");
        String newMemberName = json.getString("newMemberName");

        ServerInterface serverInterface = new ServerInterfaceImp();
        try {
            serverInterface.removeMemberFromServer(serverName, client.getUserName(), newMemberName);
            parseMessageToJson(newMemberName + " removed successfully", "removeMemberFromServer");
        }
        catch (Exceptions exception) {
            parseErrorToJson(exception, "removeMemberFromServer");
        }
    }
}

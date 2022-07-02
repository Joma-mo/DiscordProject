package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import org.json.JSONObject;
import services.ServerInterfaceImp;
import services.UserServer;

public class RemoveServerHandler extends RespondHandler{
    public RemoveServerHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {
        String serverName = json.getString("serverName");
        ServerInterfaceImp serverInterfaceImp = new ServerInterfaceImp();
        try {
            serverInterfaceImp.removeServer(serverName, client.getUserName());
        }
        catch (Exceptions exception) {
            parseErrorToJson(exception, "removeServer");
        }

    }
}

package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import org.json.JSONObject;
import services.ServerInterfaceImp;
import services.UserServer;

public class RemoveServerHandler extends RespondHandler{
    /**
     * constructor.
     * @param json receives a JSONObject,
     * @param client receives a client handler.
     */
    public RemoveServerHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    /**
     * receives server name from JSONObject,
     * pass to removeServer to remover the specific server.
     */
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

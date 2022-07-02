package responds;

import control.ClientHandler;
import org.json.JSONObject;

public class OpenAServerHandler extends RespondHandler{
    /**
     * constructor.
     * @param json receives a JSONObject,
     * @param client receives a client handler.
     */
    public OpenAServerHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    /**
     * receives server name from JSONObject.
     */
    @Override
    public void Handle() {
        String serverName = json.getString("ServerName");

    }
}

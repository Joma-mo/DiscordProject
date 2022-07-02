package responds;

import control.ClientHandler;
import org.json.JSONObject;

public class OpenAServerHandler extends RespondHandler{
    public OpenAServerHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {
        String serverName = json.getString("ServerName");

    }
}

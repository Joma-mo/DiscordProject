package responds;

import control.ClientHandler;
import org.json.JSONObject;

import java.net.Socket;

public abstract class RespondHandler {
    protected JSONObject json;
    protected ClientHandler client;

    public RespondHandler(JSONObject json, ClientHandler client) {
        this.client = client;
        this.json = json;
    }

   public abstract void Handle();
}

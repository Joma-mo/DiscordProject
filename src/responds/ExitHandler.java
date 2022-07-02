package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import org.json.JSONObject;

public class ExitHandler extends RespondHandler{
    public ExitHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {
        parseMessageToJson(" ", json.getString("menu"));
    }
}

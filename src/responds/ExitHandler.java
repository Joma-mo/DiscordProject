package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import org.json.JSONObject;

public class ExitHandler extends RespondHandler{
    /**
     * constructor.
     * @param json receives a JSONObject,
     * @param client receives a client handler.
     */
    public ExitHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    /**
     *
     */
    @Override
    public void Handle() {
        parseMessageToJson(" ", json.getString("menu"));
    }
}

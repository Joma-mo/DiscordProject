package responds;

import control.ClientHandler;
import org.json.JSONObject;

public class ReactionToMessageHandler extends RespondHandler{
    /**
     * constructor.
     * @param json receives a JSONObject,
     * @param client receives a client handler.
     */
    public ReactionToMessageHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {

    }
}

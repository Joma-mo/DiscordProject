package responds;

import control.ClientHandler;
import org.json.JSONObject;

public class ReactionToMessageHandler extends RespondHandler{
    public ReactionToMessageHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {

    }
}

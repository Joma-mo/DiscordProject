package responds;

import control.ClientHandler;
import org.json.JSONObject;

public class UnFriendHandler extends RespondHandler{
    public UnFriendHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {

    }
}

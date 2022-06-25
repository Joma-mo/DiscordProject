package responds;

import control.ClientHandler;
import org.json.JSONObject;

public class BlockedFriendHandler extends RespondHandler{
    public BlockedFriendHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {

    }
}

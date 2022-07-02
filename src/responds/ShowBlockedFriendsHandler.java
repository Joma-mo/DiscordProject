package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import org.json.JSONArray;
import org.json.JSONObject;
import services.Friend;
import services.ObserverImp;

import java.util.HashMap;
import java.util.Map;

public class ShowBlockedFriendsHandler extends RespondHandler {
    /**
     * constructor.
     * @param json receives a JSONObject,
     * @param client receives a client handler.
     */
    public ShowBlockedFriendsHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    /**
     * Showing the blocked friends,
     * Throws Exceptions.
     */
    @Override
    public void Handle() {
        try {
            parseJsonArrayToJson("showBlockedFriends");
        }
        catch (Exceptions exception) {
            parseErrorToJson(exception, "showBlockedFriends");
        }
    }
}

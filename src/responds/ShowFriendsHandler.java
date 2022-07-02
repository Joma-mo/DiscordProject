package responds;

import control.ClientHandler;
import control.Data;
import exceptions.Exceptions;
import interfaces.Observer;
import org.json.JSONArray;
import org.json.JSONObject;
import services.Friend;
import services.ObserverImp;

import java.util.HashMap;
import java.util.Map;

public class ShowFriendsHandler extends RespondHandler {
    /**
     * constructor.
     * @param json receives a JSONObject,
     * @param client receives a client handler.
     */
    public ShowFriendsHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    /**
     * showing the friends to the client.
     * Throws Exceptions.
     */
    @Override
    public void Handle() {
        try {
            parseJsonArrayToJson("showFriends");
        } catch (Exceptions exception) {
            parseErrorToJson(exception, "showFriends");
        }
    }
}

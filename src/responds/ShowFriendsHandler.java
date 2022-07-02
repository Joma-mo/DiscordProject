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

    public ShowFriendsHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {
        try {
            parseJsonArrayToJson("showFriends");
        } catch (Exceptions exception) {
            parseErrorToJson(exception, "showFriends");
        }
    }
}

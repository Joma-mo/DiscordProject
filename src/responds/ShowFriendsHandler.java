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

public class ShowFriendsHandler extends RespondHandler{

    public ShowFriendsHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {
        ObserverImp observer=new ObserverImp();
        int count = 0;
        try {
            JSONArray array = new JSONArray();
            for(Friend friend: observer.showFriends(client.getUserName())) {
                Map<String, String> map = new HashMap<>();
                map.put("userName", friend.getUserName());
                map.put("name", friend.getUserName());
                array.put(count++, map);
            }
            super.parseJsonArrayToJson(array);
        } catch (Exceptions e) {
            parseErrorToJson(e);
        }
    }
}

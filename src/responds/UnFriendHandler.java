package responds;

import control.ClientHandler;
import control.Data;
import exceptions.Exceptions;
import interfaces.Observer;
import org.json.JSONObject;
import services.Friend;
import services.ObserverImp;

public class UnFriendHandler extends RespondHandler{
    public UnFriendHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {
        String userName = json.getString("userName");
        String email = json.getString("email");

        Friend friend = new Friend(userName, email);
        Observer observer = new ObserverImp();
        try {
            observer.removeFriend(client.getUserName(), friend);
        }
        catch (Exceptions exception) {
            parseErrorToJson(exception);
        }
    }
}

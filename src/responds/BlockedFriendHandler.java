package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import interfaces.Observer;
import org.json.JSONObject;
import services.Friend;
import services.ObserverImp;

public class BlockedFriendHandler extends RespondHandler{
    public BlockedFriendHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {
        String userName = json.getString("userName");
        String email = json.getString("email");

        Friend friend = new Friend(userName, email);
        Observer observer = new ObserverImp();
        try {
            observer.blockFriend(client.getUserName(), friend);
        }
        catch (Exceptions exception) {
            parseErrorToJson(exception);
        }
    }
}

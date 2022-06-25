package responds;

import control.ClientHandler;
import interfaces.Observer;
import org.json.JSONObject;
import services.Friend;
import services.ObserverImp;
import services.UserAccount;

public class FriendRequestHandler extends RespondHandler {


    public FriendRequestHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {
        String userName = json.getString("userName");
        String email = json.getString("email");

        Friend friend = new Friend(userName, email);

        Observer observer = new ObserverImp();
        observer.addFriend(client.getUserName(), friend);
    }
}

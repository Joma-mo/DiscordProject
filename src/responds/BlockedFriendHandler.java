package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import interfaces.Observer;
import org.json.JSONObject;
import services.ObserverImp;

public class BlockedFriendHandler extends RespondHandler{
    public BlockedFriendHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {
        String friendUserName = json.getString("friendUserName");
        Observer observer = new ObserverImp();
        try {
            observer.blockFriend(client.getUserName(), friendUserName);
        }
        catch (Exceptions exception) {
            parseErrorToJson(exception, "blockedFriend");
        }
    }
}

package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import interfaces.Observer;
import org.json.JSONObject;
import services.ObserverImp;

public class BlockedFriendHandler extends RespondHandler{
    /**
     * constructor.
     * @param json receives JSONObject,
     * @param client receives a client handler.
     */
    public BlockedFriendHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    /**
     * receiving friend username from JsonObject
     * add friend to blocked friends arraylist.
     * Throws Exceptions.
     */
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

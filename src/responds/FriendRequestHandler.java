package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import interfaces.Observer;
import org.json.JSONObject;
import services.ObserverImp;

import java.util.Random;

public class FriendRequestHandler extends RespondHandler {


    /**
     * constructor.
     *
     * @param json   receives a JSONObject,
     * @param client receives a client handler.
     */
    public FriendRequestHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    /**
     * receives a friend username from JSONObject,
     * send friend request to specific user.
     * Throws Exceptions.
     */
    @Override
    public void Handle() {
        String friendUserName = json.getString("friendUserName");
        Observer observer = new ObserverImp();
        Random random = new Random();

        try {
            observer.addFriend(client.getUserName(), friendUserName);
            parseMessageToJson(friendUserName + " added successfully!", "friendRequest");
            int rand = random.nextInt(10000);
            observer.setIdToUserAccounts(client.getUserName(), friendUserName, rand);

        } catch (Exceptions exception) {
            parseErrorToJson(exception, "friendRequest");
        }
    }
}

package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import interfaces.Observer;
import org.json.JSONObject;
import services.ObserverImp;

public class RemoveFriend extends RespondHandler{
    /**
     * constructor.
     * @param json receives a JSONObject,
     * @param client receives a client handler.
     */
    public RemoveFriend(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    /**
     * receives friend username from JSONObject,
     * remove friend from friends list.
     */
    @Override
    public void Handle() {
        String friendUserName = json.getString("friendUserName");
        Observer observer = new ObserverImp();
        try {
            observer.removeFriend(client.getUserName(), friendUserName);
        }
        catch (Exceptions exception) {
            parseErrorToJson(exception, "removeFriend");
        }
    }
}

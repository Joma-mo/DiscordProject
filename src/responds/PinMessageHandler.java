package responds;

import control.ClientHandler;
import org.json.JSONObject;

public class PinMessageHandler extends RespondHandler{
    /**
     * constructor.
     * @param json receives a JSONObject,
     * @param client receives a client handler.
     */
    public PinMessageHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {

    }
}

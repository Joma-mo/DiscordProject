package responds;

import control.ClientHandler;
import org.json.JSONObject;

public class DoNothing extends RespondHandler{

    public DoNothing(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {

    }
}

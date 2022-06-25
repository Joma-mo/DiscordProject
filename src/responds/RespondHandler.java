package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import org.json.JSONObject;

import java.net.Socket;

public abstract class RespondHandler {
    protected JSONObject json;
    protected ClientHandler client;

    public RespondHandler(JSONObject json, ClientHandler client) {
        this.client = client;
        this.json = json;
    }

   public abstract void Handle();

    public void parseErrorToJson(Exceptions exceptions){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("exception",true);
        jsonObject.put("caused",exceptions.getCause());
        jsonObject.put("message",exceptions.getMessage());
        client.sendMessage(jsonObject.toString());
    }
}

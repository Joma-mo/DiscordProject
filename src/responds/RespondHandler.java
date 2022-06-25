package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.net.Socket;

public abstract class RespondHandler {
    protected JSONObject json;
    protected ClientHandler client;

    public RespondHandler(JSONObject json, ClientHandler client) {
        this.client = client;
        this.json = json;
    }

   public abstract void Handle();

    public void parseErrorToJson(Exceptions exception){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("exception",true);
        jsonObject.put("caused",exception.getCause());
        jsonObject.put("message",exception.getMessage());
        client.sendMessage(jsonObject.toString());
    }

    public void parseJsonArrayToJson(JSONArray array) {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("exception",false);
        jsonObject.put("parameterValues",array);
        client.sendMessage(jsonObject.toString());
    }
}

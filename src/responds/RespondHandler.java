package responds;

import control.ClientHandler;
import control.Data;
import exceptions.Exceptions;
import org.json.JSONArray;
import org.json.JSONObject;
import services.Friend;
import services.ObserverImp;
import services.Person;

import javax.swing.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class RespondHandler {
    protected Data data;
    protected JSONObject json;
    protected ClientHandler client;

    public RespondHandler(JSONObject json, ClientHandler client) {
        this.client = client;
        this.json = json;
        data = Data.getInstance();
    }

    public abstract void Handle();

    public void parseMessageToJson(String message, String method) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("exception", false);
        jsonObject.put("method", method);
        jsonObject.put("message", message);
        client.sendMessage(String.valueOf(jsonObject));
    }

    public void parseMessageToJson(String message, String method, String receiver) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("exception", false);
        jsonObject.put("method", method);
        jsonObject.put("message", message);
        client.sendMessage(String.valueOf(jsonObject), receiver);
    }

    public void parseErrorToJson(Exceptions exception, String method) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("exception", true);
        jsonObject.put("method", method);
        jsonObject.put("cause", exception.getCause());
        jsonObject.put("message", exception.getMessage());
        client.sendMessage(String.valueOf(jsonObject));
    }

    public void parseJsonArrayToJson(String method) throws Exceptions {
        ObserverImp observer = new ObserverImp();
        int count = 0;
        JSONArray array = new JSONArray();
        for(Friend friend : observer.listFriends(client.getUserName())) {
            Map<String, String> map = new HashMap<>();
            map.put("userName", friend.getUserName());
            map.put("status", friend.getStatus());
            array.put(count++, map);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("exception", false);
        jsonObject.put("method", method);
        jsonObject.put("message", " ");
        jsonObject.put("parameterValues", array);
        client.sendMessage(String.valueOf(jsonObject));
    }
}

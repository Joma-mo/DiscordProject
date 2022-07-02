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

    /**
     * constructor.
     * @param json receives a JSONObject,
     * @param client receives a client handler.
     */
    public RespondHandler(JSONObject json, ClientHandler client) {
        this.client = client;
        this.json = json;
        data = Data.getInstance();
    }

    public abstract void Handle();

    /**
     * @param message receives the message as a String,
     * @param method receives the method as a String,
     *               parsing them to the JsonObject and send message to the client.
     */
    public void parseMessageToJson(String message, String method) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("exception", false);
        jsonObject.put("method", method);
        jsonObject.put("message", message);
        client.sendMessage(String.valueOf(jsonObject));
    }

    /**
     * @param message receives the message as a String,
     * @param method receives the method as a String,
     *               parsing them to the JsonObject and send message to the receiver.
     * @param receiver receives the receiver name as a String.
     *
     */
    public void parseMessageToJson(String message, String method, String receiver) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("exception", false);
        jsonObject.put("method", method);
        jsonObject.put("message", message);
        client.sendMessage(String.valueOf(jsonObject), receiver);
    }

    /**
     * @param exception receives the exceptions object,
     * @param method receives the method.
     *               parse them to JsonObject and send it to the client.
     */
    public void parseErrorToJson(Exceptions exception, String method) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("exception", true);
        jsonObject.put("method", method);
        jsonObject.put("cause", exception.getCause());
        jsonObject.put("message", exception.getMessage());
        client.sendMessage(String.valueOf(jsonObject));
    }

    /**
     * @param method receives the method as a String.
     *               parsing array to Json and send it to client.
     * @throws Exceptions
     */
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

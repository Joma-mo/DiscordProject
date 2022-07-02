package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import org.json.JSONObject;
import services.AuthenticationImp;

public class LogInRespondHandler extends RespondHandler{

    public LogInRespondHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {
        String userName = json.getString("userName");
        String password = json.getString("password");

        AuthenticationImp authenticationImp = new AuthenticationImp();

        try {
            authenticationImp.logIn(userName, password);
            parseMessageToJson("Welcome to your Account", "logIn");
        }
        catch (Exceptions e) {
            parseErrorToJson(e, "logIn");
        }

    }
}

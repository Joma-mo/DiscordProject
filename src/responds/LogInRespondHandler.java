package responds;

import control.ClientHandler;
import exceptions.Exceptions;
import org.json.JSONObject;
import services.AuthenticationImp;

public class LogInRespondHandler extends RespondHandler{

    /**
     * constructor.
     * @param json receives a JSONObject,
     * @param client receives a client handler.
     */
    public LogInRespondHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    /**
     * receiving username and password from JSONObject,
     * and pass them to authenticationImp for logIn.
     * Trows Exceptions.
     */
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

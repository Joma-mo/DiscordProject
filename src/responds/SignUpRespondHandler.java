package responds;

import control.ClientHandler;
import exceptions.*;
import interfaces.Authentication;
import org.json.JSONObject;
import services.AuthenticationImp;
import services.UserAccount;

public class SignUpRespondHandler extends RespondHandler{
    public SignUpRespondHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {
        String userName=json.getString("userName");
        String password=json.getString("password");
        String email = json.getString("email");
        String phoneNumber = json.getString("phoneNumber");

        // Check the format of userName
        try {
            checkUserName(userName);
        }
        catch (Exceptions exception) {
            parseErrorToJson(exception, "signUp");
        }

        // Check the format of password
        try {
            checkPassword(password);
        }
        catch (Exceptions exception) {
            parseErrorToJson(exception, "signUp");
        }

        // Check the format of email
        try {
            checkEmail(email);
        }
        catch (Exceptions exception) {
            parseErrorToJson(exception, "signUp");
        }

        // Check the format of phone number
        try {
            checkPhoneNumber(phoneNumber);
        }
        catch (Exceptions exception) {
            parseErrorToJson(exception, "signUp");
        }

        UserAccount user = new UserAccount(userName, password, email);

        Authentication authentication = new AuthenticationImp();
        try {
            authentication.signUp(user);
            parseMessageToJson("User added successfully", "signUp");
        }
        catch (Exceptions exception) {
            parseErrorToJson(exception, "signUp");
        }
    }

    public void checkUserName(String userName) throws Exceptions {
        String pattern = "^[a-zA-Z0-9_.]{6,20}$";

        if (!userName.matches(pattern)) {
            throw new UserNameFormatException();
        }
    }

    public void checkPassword(String password) throws Exceptions {
        String pattern = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";

        if(!password.matches(pattern)) {
            throw new PasswordFormatException();
        }
    }

    public void checkEmail(String email) throws Exceptions {
        String pattern = "^(.+)@(\\S+)$";

        if(!email.matches(pattern)) {
            throw new EmailFormatException();
        }
    }

    public void checkPhoneNumber(String phoneNumber) throws Exceptions {
        String pattern = "^(\\+\\d{1,2}\\s?)?1?\\-?\\.?\\s?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";

        if(!phoneNumber.matches(pattern)) {
            throw new PhoneNumberFormatException();
        }
    }


}

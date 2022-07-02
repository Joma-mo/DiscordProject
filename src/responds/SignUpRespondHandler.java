package responds;

import control.ClientHandler;
import exceptions.*;
import interfaces.Authentication;
import org.json.JSONObject;
import services.AuthenticationImp;
import services.UserAccount;

public class SignUpRespondHandler extends RespondHandler{
    /**
     * constructor.
     * @param json receives a JSONObject,
     * @param client receives a client handler.
     */
    public SignUpRespondHandler(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    /**
     * receives the username, password, email, and phone number from JsonObject
     * and check them.
     */
    @Override
    public void Handle() {
        String userName=json.getString("userName");
        String password=json.getString("password");
        String email = json.getString("email");
        String phoneNumber = json.getString("phoneNumber");

        // Check userName format
        try {
            checkUserName(userName);
        }
        catch (Exceptions exception) {
            parseErrorToJson(exception, "signUp");
        }

        // Check password format
        try {
            checkPassword(password);
        }
        catch (Exceptions exception) {
            parseErrorToJson(exception, "signUp");
        }

        // Check email format
        try {
            checkEmail(email);
        }
        catch (Exceptions exception) {
            parseErrorToJson(exception, "signUp");
        }

        // Check phone number format
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

    /**
     * @param userName receives a userName as a String,
     *                 check if userName contains lower case, upper case letter
     *                 and length must be more than 6 characters.
     * @throws Exceptions
     */
    public void checkUserName(String userName) throws Exceptions {
        String pattern = "^[a-zA-Z0-9_.]{6,20}$";

        if (!userName.matches(pattern)) {
            throw new UserNameFormatException();
        }
    }

    /**
     * @param password check if the password contains more than 8 characters, has lower case,
     *                 upper case and special characters.
     * @throws Exceptions
     */
    public void checkPassword(String password) throws Exceptions {
        String pattern = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";

        if(!password.matches(pattern)) {
            throw new PasswordFormatException();
        }
    }

    /**
     * @param email check if the email contains @.
     * @throws Exceptions
     */
    public void checkEmail(String email) throws Exceptions {
        String pattern = "^(.+)@(\\S+)$";

        if(!email.matches(pattern)) {
            throw new EmailFormatException();
        }
    }

    /**
     * @param phoneNumber check if phone number has 10 digits, no matter if you
     *                    write the international code also.
     * @throws Exceptions
     */
    public void checkPhoneNumber(String phoneNumber) throws Exceptions {
        String pattern = "^(\\+\\d{1,2}\\s?)?1?\\-?\\.?\\s?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";

        if(!phoneNumber.matches(pattern)) {
            throw new PhoneNumberFormatException();
        }
    }


}

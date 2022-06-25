package responds;

import control.ClientHandler;
import exceptions.*;
import interfaces.Authentication;
import org.json.JSONObject;
import services.AuthenticationImp;
import services.UserAccount;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            client.sendMessage(exception.getMessage(), client.getUserName());
        }

        // Check the format of password
        try {
            checkPassword(password);
        }
        catch (Exceptions exception) {
            client.sendMessage(exception.getMessage(), client.getUserName());
        }

        // Check the format of email
        try {
            checkEmail(email);
        }
        catch (Exceptions exception) {
            client.sendMessage(exception.getMessage(), client.getUserName());
        }

        // Check the format of phone number
        try {
            checkPhoneNumber(phoneNumber);
        }
        catch (Exceptions exception) {
            client.sendMessage(exception.getMessage(), client.getUserName());
        }

        UserAccount user = new UserAccount(userName, password, email);
        client.sendMessage("user added successfully");

        Authentication authentication=new AuthenticationImp();
        try {
            authentication.signUp(user);
        }
        catch (Exceptions exception) {
            client.sendMessage(exception.getMessage(), client.getUserName());
        }
    }

    public void checkUserName(String userName) throws Exceptions {
        if (userName.length() < 6) {
            throw new UserNameFormatException("The userName should be more than 6 character");
        }

        Pattern p = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{6,}$");
        Matcher m = p.matcher(userName);
        if(m.find()) {
            throw new UserNameFormatException("Invalid userName");
        }
    }

    public void checkPassword(String password) throws Exceptions {
        Pattern p = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
        Matcher m = p.matcher(password);
        if(!m.find()) {
            throw new PasswordFormatException();
        }
    }

    public void checkEmail(String email) throws Exceptions {
        if(email.contains("@")) {
            String []splitEmail = email.split("@");

            if(!splitEmail[1].equals("gmail.com")) {
                throw new EmailFormatException();
            }
        } else {
            throw new EmailFormatException();
        }
    }

    public void checkPhoneNumber(String phoneNumber) throws Exceptions {
        Pattern p = Pattern.compile("^(\\+\\d{1,2}\\s?)?1?\\-?\\.?\\s?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$");
        Matcher m = p.matcher(phoneNumber);

        if(!m.find()) {
            throw new PhoneNumberFormatException();
        }
    }


}

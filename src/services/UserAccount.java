package services;

import java.util.ArrayList;

public class UserAccount extends Person {
    private String password;
    private Status status;

    /**
     * first constructor.
     * @param userName receives a userName,
     * @param password receives a password,
     * @param email receives an email.
     */
    public UserAccount(String userName, String password, String email) {
        super(userName, email);
        this.password = password;
    }

    /**
     * second constructor.
     * @param userName receives a userName,
     * @param password receives a password,
     * @param email receives an email,
     * @param phoneNumber receives a phone number.
     */
    public UserAccount(String userName, String password, String email, String phoneNumber) {
        super(userName, email, phoneNumber);
        this.password = password;
    }

    /**
     * @return return password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param status set the current status.
     */
    public void setStatus(Status status) {
        this.status = status;
    }
}

package services;

import java.util.ArrayList;

public class UserAccount extends Person {
    private String password;
    private Status status;

    public UserAccount(String userName, String password, String email) {
        super(userName, email);
        this.password = password;
        messages = new ArrayList<>();
    }

    public UserAccount(String userName, String password, String email, String phoneNumber) {
        super(userName, email, phoneNumber);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

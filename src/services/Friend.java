package services;

public class Friend extends Person {
    /**
     * constructor.
     * @param userName receives a userName,
     * @param email receives an email.
     */
    public Friend(String userName, String email) {
        super(userName, email);
    }

    /**
     * constructor.
     * @param userName receives a userName,
     * @param email receives an email.
     * @param phoneNumber receives a phone number.
     */
    public Friend(String userName, String email, String phoneNumber) {
        super(userName, email, phoneNumber);
    }
}

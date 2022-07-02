package services;

/**
 * every person has a username, email.
 */
public class Person {
    private String userName;
    private String email;
    private String phoneNumber;

    /**
     * first constructor.
     * @param userName receives a userName,
     * @param email receives an email.
     */
    public Person(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }


    /**
     * second constructor.
     * @param userName receives a userName,
     * @param email receives an email,
     * @param phoneNumber receives a phone number.
     */
    public Person(String userName, String email, String phoneNumber) {
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

}

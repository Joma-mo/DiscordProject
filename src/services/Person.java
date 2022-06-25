package services;

public class Person {
    private String userName;
    private String email;
    private String phoneNumber;

    public Person(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public Person(String userName, String email, String phoneNumber) {
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

}

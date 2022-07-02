package interfaces;

import exceptions.Exceptions;
import services.UserAccount;

/**
 * Authentication interface with 2 methods: signUp and logIn.
 */
public interface Authentication {
    void signUp(UserAccount user) throws Exceptions;
    void logIn(String userName,String password)throws Exceptions;
}

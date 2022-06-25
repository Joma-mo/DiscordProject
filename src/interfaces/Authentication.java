package interfaces;

import exceptions.Exceptions;
import services.UserAccount;

public interface Authentication {
    void signUp(UserAccount user) throws Exceptions;
    void logIn(String userName,String password)throws Exceptions;
}

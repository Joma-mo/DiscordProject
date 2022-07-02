package services;

import control.Data;
import exceptions.DataHasAlreadyExistException;
import exceptions.Exceptions;
import exceptions.IncorrectUserNameOrPasswordException;
import interfaces.Authentication;

/**
 * implementing the Authentication interface
 */
public class AuthenticationImp implements Authentication {
    Data data;

    /**
     * @param user receives a user Account,
     *             if user exists Throws an exception, else add user.
     * @throws Exceptions
     */
    @Override
    public void signUp(UserAccount user) throws Exceptions {
        if(data.isExist(user.getUserName())) {
            throw new DataHasAlreadyExistException();
        }
        data.addUser(user);
    }

    /**
     * @param userName receives the userName,
     * @param password receives the password,
     *                 if we did not have any user with this userName and password,
     *                 throw an exception.
     * @throws Exceptions
     */
    @Override
    public void logIn(String userName, String password) throws Exceptions {
        if(!data.checkTheUser(userName, password)) {
            throw new IncorrectUserNameOrPasswordException();
        }
    }
}

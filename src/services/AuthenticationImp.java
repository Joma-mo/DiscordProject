package services;

import control.Data;
import exceptions.DataHasAlreadyExistException;
import exceptions.Exceptions;
import exceptions.IncorrectUserNameOrPasswordException;
import interfaces.Authentication;

public class AuthenticationImp implements Authentication {
    Data data;

    @Override
    public void signUp(UserAccount user) throws Exceptions {
        if(data.isExist(user.getUserName())) {
            throw new DataHasAlreadyExistException();
        }
        data.addUser(user);
    }

    @Override
    public void logIn(String userName, String password) throws Exceptions {
        if(!data.checkTheUser(userName, password)) {
            throw new IncorrectUserNameOrPasswordException();
        }
    }
}

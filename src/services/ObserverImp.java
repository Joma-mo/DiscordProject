package services;

import control.Data;
import exceptions.DataHasAlreadyExistException;
import exceptions.Exceptions;
import interfaces.Observer;

public class ObserverImp implements Observer {
    Data data;

    @Override
    public void addFriend(String userName, Friend friend) throws Exceptions {
        if(data.isExist(userName, friend)) {
            throw new DataHasAlreadyExistException(friend.getUserName() + " is already your friend");
        } else {
            data.addFriend(userName, friend);
        }
    }

    @Override
    public void removeFriend(String userName, Friend friend) throws Exceptions {
        if(!data.isExist(userName, friend)) {
            throw new DataHasAlreadyExistException(friend.getUserName() + " is not your friend");
        } else {
            data.removeFriend(userName, friend);
        }

    }

    @Override
    public void blockFriend(String userName, Friend friend) throws Exceptions {
        if(!data.isExist(userName, friend)) {
            throw new DataHasAlreadyExistException(friend.getUserName() + " is not your friend!");
        } else {
            data.addToBlockedFriend(userName, friend);
        }
    }
}

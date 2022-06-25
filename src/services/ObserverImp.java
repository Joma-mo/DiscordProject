package services;

import control.Data;
import exceptions.DataHasAlreadyExistException;
import exceptions.Exceptions;
import exceptions.InvalidDataException;
import interfaces.Observer;

import java.util.ArrayList;

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

    @Override
    public ArrayList<Friend> showFriends(String userName) throws Exceptions {
        if(!data.isExist(userName))
            throw new InvalidDataException(userName+" is Not exist");
        return data.listFriends(userName);
    }
}

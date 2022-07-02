package services;

import control.Data;
import exceptions.DataHasAlreadyExistException;
import exceptions.Exceptions;
import exceptions.InvalidDataException;
import interfaces.Observer;

import java.util.ArrayList;

/**
 * implementing the observer interface.
 */
public class ObserverImp implements Observer {
    Data data;

    /**
     * @param userName receives username,
     * @param friend  receives friend object,
     *                adding the friend.
     * @throws Exceptions
     */
    @Override
    public void addFriend(String userName, Friend friend) throws Exceptions {
        if(data.isExist(userName, friend)) {
            throw new DataHasAlreadyExistException(friend.getUserName() + " is already your friend");
        } else {
            data.addFriend(userName, friend);
        }
    }

    /**
     * @param userName receives username,
     * @param friend receives a friend object,
     *               remove friend.
     * @throws Exceptions
     */
    @Override
    public void removeFriend(String userName, Friend friend) throws Exceptions {
        if(!data.isExist(userName, friend)) {
            throw new DataHasAlreadyExistException(friend.getUserName() + " is not your friend");
        } else {
            data.removeFriend(userName, friend);
        }

    }

    /**
     * @param userName receives a userName,
     * @param friend receives a friend object,
     *               add to block friends.
     * @throws Exceptions
     */
    @Override
    public void blockFriend(String userName, Friend friend) throws Exceptions {
        if(!data.isExist(userName, friend)) {
            throw new DataHasAlreadyExistException(friend.getUserName() + " is not your friend!");
        } else {
            data.addToBlockedFriend(userName, friend);
        }
    }

    /**
     * @param userName receives a userName,
     * @return if userName exists return arraylist of friends.
     * @throws Exceptions
     */
    @Override
    public ArrayList<Friend> showFriends(String userName) throws Exceptions {
        if(!data.isExist(userName))
            throw new InvalidDataException(userName+" is Not exist");
        return data.listFriends(userName);
    }
}

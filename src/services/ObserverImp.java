package services;

import control.Data;
import exceptions.DataHasAlreadyExistException;
import exceptions.Exceptions;
import interfaces.Observer;

public class ObserverImp implements Observer {
    Data data;

    @Override
    public void addFriend(String userName, Friend friend) throws Exceptions {
        if(!data.isExist(userName))
            throw new DataHasAlreadyExistException(userName+"is Already your friend");
        else
            data.addFriend(null,friend);
    }

    @Override
    public void removeFriend(String userName, Friend friend) {
        data.addFriend(data.findUser(userName), friend);
    }

    @Override
    public void blockFriend(String userName, Friend friend) {
        data.addToBlockedFriend(null,null);
    }
}

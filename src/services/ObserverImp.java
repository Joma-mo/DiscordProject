package services;

import control.Data;
import interfaces.Observer;

public class ObserverImp implements Observer {
    Data data;

    @Override
    public void addFriend(String userName, Friend friend) {
        data.addFriend(data.findUser(userName), friend);
    }

    @Override
    public void removeFriend(String userName, Friend friend) {
        data.addFriend(data.findUser(userName), friend);
    }

    @Override
    public void blockFriend(String userName, Friend friend) {

    }
}

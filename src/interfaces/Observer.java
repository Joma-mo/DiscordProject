package interfaces;

import exceptions.Exceptions;
import services.Friend;
import services.UserAccount;

public interface Observer {
    void addFriend(String userName, Friend friend) throws Exceptions;
    void removeFriend(String userName, Friend friend) throws Exceptions;
    void blockFriend(String userName, Friend friend) throws Exceptions;
}

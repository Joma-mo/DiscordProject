package interfaces;

import services.Friend;
import services.UserAccount;

public interface Observer {
    void addFriend(String userName, Friend friend);
    void removeFriend(String userName, Friend friend);
    void blockFriend(String userName, Friend friend);
}

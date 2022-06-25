package control;

import services.Friend;
import services.Message;
import services.UserAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Data {
    private ArrayList<UserAccount> accounts;
    private HashMap<UserAccount, HashSet<Friend>> friends;
    private HashMap<UserAccount, HashSet<Friend>> blockedFriends;
    private HashMap<UserAccount, ArrayList<Message>> messages;
    private Database database;


    public boolean isExist(String userName) {
        for (UserAccount user : accounts) {
            return user.getUserName().equals(userName);
        }
        return false;
    }

    public void addUser(UserAccount user) {
        accounts.add(user);
        friends.put(user, new HashSet<>());
        messages.put(user, new ArrayList<>());
        blockedFriends.put(user, new HashSet<>());
    }

    public void addFriend(UserAccount user, Friend friend) {
        friends.get(user).add(friend);
    }

    public void removeFriend(UserAccount user, Friend friend) {
        friends.get(user).remove(friend);
    }

    public void addMessage(UserAccount user, Message message) {
        messages.get(user).add(message);
    }

    public void addToBlockedFriend(UserAccount user, Friend friend) {
        blockedFriends.get(user).add(friend);
    }

    public UserAccount findUser(String userName) {
        for(UserAccount user : accounts) {
            if(user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    public void saveAllUsersToFile() {
        database.saveUsers(accounts);
    }

    public void saveAllFriends() {
        database.saveFriends(friends);
    }

    public boolean checkTheUser(String userName, String password) {
        for(UserAccount user : accounts) {
            if(user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}

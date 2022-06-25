package control;

import services.Friend;
import services.Message;
import services.UserAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Data {
    private ArrayList<UserAccount> accounts;
    private HashMap<UserAccount, ArrayList<Friend>> friends;
    private HashMap<UserAccount, HashSet<Friend>> blockedFriends;
    private HashMap<UserAccount, ArrayList<Message>> messages;
    private Database database;


    public boolean isExist(String userName) {
        for (UserAccount user : accounts) {
            return user.getUserName().equals(userName);
        }
        return false;
    }

    public boolean isExist(String userName, Friend friend) {
        for(Friend x : friends.get(findUser(userName))) {
            return x.equals(friend);
        }
        return false;
    }

    public void addUser(UserAccount user) {
        accounts.add(user);
        friends.put(user, new ArrayList<>());
        messages.put(user, new ArrayList<>());
        blockedFriends.put(user, new HashSet<>());
    }

    public void addFriend(String userName, Friend friend) {
        friends.get(findUser(userName)).add(friend);
    }

    public void removeFriend(String userName, Friend friend) {
        friends.get(findUser(userName)).remove(friend);
    }

    public void addMessage(String userName, Message message) {
        messages.get(findUser(userName)).add(message);
    }

    public void addToBlockedFriend(String userName, Friend friend) {
        blockedFriends.get(findUser(userName)).add(friend);
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

    public ArrayList<Friend> listFriends(String userName) {
        return friends.get(findUser(userName));
    }
}

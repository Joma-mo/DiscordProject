package control;

import services.Friend;
import services.Message;
import services.UserAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * storing all the data of a user account.
 */
public class Data {
    private ArrayList<UserAccount> accounts;
    private HashMap<UserAccount, ArrayList<Friend>> friends;
    private HashMap<UserAccount, HashSet<Friend>> blockedFriends;
    private HashMap<UserAccount, ArrayList<Message>> messages;
    private Database database;


    /**
     * @param userName getting a username, and searching in UserAccount arraylist.
     * @return true if user exist, False if user does not exist.
     */
    public boolean isExist(String userName) {
        for (UserAccount user : accounts) {
            return user.getUserName().equals(userName);
        }
        return false;
    }

    /**
     * @param userName receives a username,
     * @param friend searching in Friends arraylist
     * @return True if user exist, False if user does not exist.
     */
    public boolean isExist(String userName, Friend friend) {
        for(Friend x : friends.get(findUser(userName))) {
            return x.equals(friend);
        }
        return false;
    }

    /**
     * @param user receives a user Account, adding to arraylist account,
     *             creating a new user account for it, with new friends, messages and blocked friends.
     */
    public void addUser(UserAccount user) {
        accounts.add(user);
        friends.put(user, new ArrayList<>());
        messages.put(user, new ArrayList<>());
        blockedFriends.put(user, new HashSet<>());
    }

    /**
     * @param userName receives a user name,
     * @param friend receives a friend object,
     *               add friend if user is valid.
     */
    public void addFriend(String userName, Friend friend) {
        friends.get(findUser(userName)).add(friend);
    }

    /**
     * @param userName receives a username,
     * @param friend receives a friend object,
     *               remove friend if user is valid.
     */
    public void removeFriend(String userName, Friend friend) {
        friends.get(findUser(userName)).remove(friend);
    }

    /**
     * @param userName receives a username,
     * @param message receives a message,
     *                add message if user exists.
     */
    public void addMessage(String userName, Message message) {
        messages.get(findUser(userName)).add(message);
    }

    /**
     * @param userName receives a username,
     * @param friend receives a friend object,
     *               add user to block list if user is valid.
     */
    public void addToBlockedFriend(String userName, Friend friend) {
        blockedFriends.get(findUser(userName)).add(friend);
    }

    /**
     * @param userName receives a username, search in user Accounts,
     * @return True if user exists, False if user does not exist.
     */
    public UserAccount findUser(String userName) {
        for(UserAccount user : accounts) {
            if(user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    /**
     * saving all user accounts to binary file.
     */
    public void saveAllUsersToFile() {
        database.saveUsers(accounts);
    }

    /**
     * saving all friends to binary file.
     */
    public void saveAllFriends() {
        database.saveFriends(friends);
    }

    /**
     * @param userName receives a username,
     * @param password receives a password,
     * @return True if username and password is valid, and return False if username and
     *          password is not valid.
     */
    public boolean checkTheUser(String userName, String password) {
        for(UserAccount user : accounts) {
            if(user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param userName receives a username,
     * @return returns Friends of the specific user.
     */
    public ArrayList<Friend> listFriends(String userName) {
        return friends.get(findUser(userName));
    }
}

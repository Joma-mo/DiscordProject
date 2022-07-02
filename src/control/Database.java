package control;

import services.Friend;
import services.UserAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Database {
    private static Database database;

    /**
     * constructor
     */
    private Database() {
    }

    /**
     * @return return new database
     */
    public static Database getInstance() {
        if (database == null)
            database = new Database();
        return database;
    }


    /**
     * @param accounts saving the users in a binary file.
     */
    public void saveUsers(ArrayList<UserAccount> accounts) {
        saveObject(accounts, "file/users.bin");
    }

    /**
     * @return returns the object user account arraylist.
     */
    public ArrayList<UserAccount> getUser() {
        Object obj = readObject("file/users.bin");
        if (obj == null)
            return new ArrayList<>();
        else
            return (ArrayList<UserAccount>) obj;
    }

    /**
     * @param friends saving friends to a specific file path.
     */
    public void saveFriends(HashMap<UserAccount, ArrayList<Friend>> friends) {
        saveObject(friends, "file/friends.bin");
    }

    /**
     * @return return the object userAccount and friend hashmap.
     */
    public HashMap<UserAccount, Friend> getFriends() {
        Object obj = readObject("file/friends.bin");
        if (obj == null) {
            return new HashMap<>();
        } else
            return (HashMap<UserAccount, Friend>) obj;
    }
    /**
     * @param object receives an object,
     * @param path receives a file path,
     *             saves specified object to a file.
     *             Throws IOException.
     */
    private void saveObject(Object object, String path) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path));
            output.writeObject(object);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * @param path receives a file path,
     * @return object with specified path.
     *          Throw IOException and ClassNotFoundException.
     */
    private Object readObject(String path) {
        Object object = null;
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
            object = input.readObject();
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return object;
    }
}

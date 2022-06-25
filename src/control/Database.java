package control;

import services.Friend;
import services.UserAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Database {
    private static Database database;

    private Database() {
    }

    public static Database getInstance() {
        if (database == null)
            database = new Database();
        return database;
    }


    public void saveUsers(ArrayList<UserAccount> accounts) {
        saveObject(accounts,"file/users.bin");
    }

    public ArrayList<UserAccount> getUser() {
        Object obj=readObject("file/users.bin");
        if(obj==null)
           return new ArrayList<>();
        else
           return (ArrayList<UserAccount>) obj;
    }

    public void saveFriends(HashMap<UserAccount, HashSet<Friend>> friends) {
        saveObject(friends, "file/friends.bin");
    }

    public HashMap<UserAccount, Friend> getFriends() {
        Object obj = readObject("file/friends.bin");
        if(obj == null) {
            return new HashMap<>();
        }
        else
            return (HashMap<UserAccount, Friend>) obj;
    }

    private void saveObject(Object object,String path) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path));
            output.writeObject(object);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private Object readObject(String path) {
        Object object=null;
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
            object = input.readObject();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return object;
    }
}

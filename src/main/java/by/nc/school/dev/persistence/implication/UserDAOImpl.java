package by.nc.school.dev.persistence.implication;


import by.nc.school.dev.persistence.InmemoryStorage;
import by.nc.school.dev.persistence.UserDAO;
import by.nc.school.dev.model.user.User;
import org.springframework.beans.factory.annotation.Required;

import java.io.*;
import java.util.*;

public class UserDAOImpl implements UserDAO {

    protected InmemoryStorage storage;

    public UserDAOImpl() {}

    public List<User> getAll() {
        return storage.getUsers();
    }

    public User getUser(String login) {
        if (login == null) {
            return null;
        }
        for (User user : storage.getUsers()) {
            if (login.equals(user.getUsername())) {
                return user;
            }
        }
        return null;
    }

    public void create(User user) {

    }

    @Override
    public void delete(String userName) {
        for (User user : storage.getUsers()) {
            if (userName.equals(user.getUsername())) {
                storage.getUsers().remove(user);
                storage.save();
            }
        }
    }

    @Required
    public void setStorage(InmemoryStorage storage) {
        this.storage = storage;
    }

//    ObjectOutputStream objectOutputStream;
//    ObjectInputStream objectInputStream;
//    List<User> users;
//    File file = new File("Students.dat");;
//
//    public User get(int id) {
//        return null;
//    }
//
//    public void create(User user){
//        users = new ArrayList<User>();
//        read(file, users);
//        users.add(user);
//        write(file, users);
//    }
//
//    public void update(User user) {
//
//    }
//
//    public void delete(String userName) {
//        users = new ArrayList<User>();
//        read(file, users);
//        for(User user: users)
//        {
//            if(user.getUsername().equals(userName))
//            {
//
//            }
//        }
//
//    }
//
//    public List<User> getAll() {
//        users = new ArrayList<User>();
//        read(file, users);
//        return users;
//    }
//
//    public User getByUsername(String username) {
//        users = new ArrayList<User>();
//        read(file, users);
//        for(User user: users)
//        {
//            if(user.getUsername().equals(username))
//                return user;
//        }
//        return null;
//    }
//
//    static void write(File data, List<User> list) {
//        try{
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(data)));
//            objectOutputStream.writeObject(list);
//            objectOutputStream.close();
//        }
//        catch (IOException ex)
//        {}
//    }
//
//    static void read(File data, List<User> list){
//        try{
//            ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(data)));
//            list = (ArrayList) objectInputStream.readObject();
//            objectInputStream.close();
//        }
//        catch (IOException ex)
//        {}
//        catch (Exception e)
//        {}
//    }
}

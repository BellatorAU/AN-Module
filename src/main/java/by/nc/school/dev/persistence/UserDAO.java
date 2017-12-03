package by.nc.school.dev.persistence;

import by.nc.school.dev.model.user.User;

import java.util.List;

public interface UserDAO {

    List<User> getAll();

    User getUser(String login);

    void create(User user);

    void delete(String userName);


//    User get(int id);
//
//    User getByUsername(String username);
//
//    void create(User user);
//
//    void update(User user);
//
//    void delete(String userName);
//
//    List<User> getAll();

}

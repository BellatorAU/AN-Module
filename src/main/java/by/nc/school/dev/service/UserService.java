package by.nc.school.dev.service;

import by.nc.school.dev.model.user.User;

public interface UserService {
    void addUser(User user);
    boolean login(String userName, String password);
    void geleteUser(String userName);
    void update(User user);
}
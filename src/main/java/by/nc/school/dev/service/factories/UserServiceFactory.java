package by.nc.school.dev.service.factories;

import by.nc.school.dev.service.UserService;
import by.nc.school.dev.service.implication.UserServiceImpl;

public class UserServiceFactory {

    public static UserService userDaoInstance;

    public static UserService getInstance()
    {
        if (userDaoInstance == null) {
            userDaoInstance = new UserServiceImpl();
        }
        return userDaoInstance;
    }
}

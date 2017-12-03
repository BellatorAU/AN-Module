package by.nc.school.dev.persistence.factories;

import by.nc.school.dev.persistence.UserDAO;
import by.nc.school.dev.persistence.implication.UserDAOImpl;

public class UserDAOFactory{

    protected static UserDAO userDaoInstance;

    public static UserDAO getInstance() {
        synchronized (UserDAO.class) {
            if (userDaoInstance == null) {
                UserDAOImpl userDao = new UserDAOImpl();
                userDaoInstance = userDao;
            }
        }
        return userDaoInstance;
    }
}

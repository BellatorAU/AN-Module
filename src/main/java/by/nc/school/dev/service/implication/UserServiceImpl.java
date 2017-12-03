package by.nc.school.dev.service.implication;

import by.nc.school.dev.persistence.UserDAO;
import by.nc.school.dev.persistence.factories.UserDAOFactory;
import by.nc.school.dev.model.user.User;
import by.nc.school.dev.service.UserService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDAO userDAO;

    public void addUser(User user) {
        userDAO = UserDAOFactory.getInstance();
        userDAO.create(user);
    }

    public boolean login(String userName, String password) {
        List<User> users = userDAO.getAll();
        for (User user : users) {
            if (user.getUsername().equals(userName) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void geleteUser(String userName) {
        userDAO = UserDAOFactory.getInstance();
        userDAO.delete(userName);
    }

    public void getByUserName(String userName){
        userDAO = UserDAOFactory.getInstance();
    }

    public void update(User user) {

    }
    @Required
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}

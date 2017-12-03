package by.nc.school.dev.web.provider;

import by.nc.school.dev.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Required;

import javax.servlet.http.HttpServletRequest;

public class HomeModelProvider implements ModelProvider {

    protected UserDAO userDAO;

    private HomeModelProvider() {}

    public void fillRequest(HttpServletRequest request) {
        request.setAttribute("users", userDAO.getAll());
    }

    @Required
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

}

package by.nc.school.dev.web.command;

import by.nc.school.dev.model.user.User;
import by.nc.school.dev.model.user.UserBuilder;
import by.nc.school.dev.persistence.UserDAO;
import by.nc.school.dev.web.Pages;
import org.springframework.beans.factory.annotation.Required;

import javax.servlet.http.HttpServletRequest;

class NewUserCommand implements Command {

    protected UserDAO userDAO;

    NewUserCommand() {}

    public String execute(HttpServletRequest request) {
        User newUser = new UserBuilder()
                .setLogin(request.getParameter("username"))
                .setPassword(request.getParameter("password"))
                .build();
        userDAO.create(newUser);
        return Pages.HOME_PAGE;
    }

    @Required
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}

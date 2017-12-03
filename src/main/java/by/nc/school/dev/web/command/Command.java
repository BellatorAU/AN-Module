package by.nc.school.dev.web.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {

    String execute(HttpServletRequest request);

}

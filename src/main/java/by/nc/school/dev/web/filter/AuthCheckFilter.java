package by.nc.school.dev.web.filter;

import by.nc.school.dev.web.Pages;
import by.nc.school.dev.web.command.CommandNames;
import by.nc.school.dev.web.command.SessionAttributes;
import by.nc.school.dev.web.controller.Controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class AuthCheckFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (Boolean.TRUE.equals(request.getSession().getAttribute(SessionAttributes.IS_LOGGED_IN)) || isIgnoreRequest(request)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect(Pages.LOGIN_PAGE);
        }
    }

    private boolean isIgnoreRequest(HttpServletRequest request) {
        return "/".equals(request.getRequestURI())
               || Pages.LOGIN_PAGE.equals(request.getRequestURI())
               || request.getRequestURI().startsWith("/src/")
               || (
                       Pages.CONTROLLER.equals(request.getRequestURI())
                       && request.getParameter(Controller.COMMAND_PARAM).equals(CommandNames.LOGIN)
               );
    }

    public void init(FilterConfig filterConfig) throws ServletException {}

    public void destroy() {}
}

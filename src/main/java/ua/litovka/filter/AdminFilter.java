package ua.litovka.filter;

import ua.litovka.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SergLion on 24.02.2017.
 */
@WebFilter(filterName = "AdminFilter", urlPatterns = "/pages/admin/*")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
        if (userDTO != null && userDTO.getRole().getName().equals("user")) {
            filterChain.doFilter(request, response);
        } else {
            request.getSession().setAttribute("url", request.getRequestURI());
            request.getSession().setAttribute("message", "You have to be admin");
            response.sendRedirect(request.getContextPath() + "/pages/common/login.jsp");
        }

    }

    @Override
    public void destroy() {

    }
}

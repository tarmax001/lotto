package by.tarmax.lotto.web;

import by.tarmax.lotto.SecurityUtil;
import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class UserServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("redirect to bids");
        Integer userId = Integer.parseInt(req.getParameter("userId"));
        SecurityUtil.setUserId(userId);
        resp.sendRedirect("bids");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to users");
//        request.setAttribute("users", );
        request.getRequestDispatcher("/users.jsp").forward(request, response);
//        response.sendRedirect("users.jsp");
    }
}

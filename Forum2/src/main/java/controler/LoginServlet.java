package controler;

import model.User;
import model.ForumService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private ForumService forumService = new ForumService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = forumService.checkUser(username, password);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("listTopics");
        } else {
            req.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
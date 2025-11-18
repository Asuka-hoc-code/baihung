package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ForumService;

@WebServlet("/listTopics")
public class TopicListServlet extends HttpServlet {
    private ForumService forumService = new ForumService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("topics", forumService.getTopics());
        req.getRequestDispatcher("listTopics.jsp").forward(req, resp);
    }
}
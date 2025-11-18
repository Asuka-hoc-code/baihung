package controler;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ForumService;
@WebServlet("/showTopic")
public class ShowTopicServlet extends HttpServlet {
    private ForumService forumService = new ForumService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String topicId = req.getParameter("topicId");
        if (topicId != null) {
            try {
                Long id = Long.parseLong(topicId);
                req.setAttribute("topic", forumService.getTopicById(id));
                req.getRequestDispatcher("showTopic.jsp").forward(req, resp);
            } catch (NumberFormatException e) {
                resp.sendRedirect("listTopics");
            }
        } else {
            resp.sendRedirect("listTopics");
        }
    }
}
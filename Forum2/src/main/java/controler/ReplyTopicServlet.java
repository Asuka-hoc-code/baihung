package controler;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ForumService;
import model.Message;
import model.User;

@WebServlet("/replyTopic")
public class ReplyTopicServlet extends HttpServlet {
    private ForumService forumService = new ForumService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String topicId = req.getParameter("topicId");
        req.setAttribute("topicId", topicId);
        req.getRequestDispatcher("replyTopic.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        String topicId = req.getParameter("topicId");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        if (topicId != null) {
            try {
                Long id = Long.parseLong(topicId);
                Message message = new Message(System.currentTimeMillis(), title, content, Calendar.getInstance(), user);
                forumService.addMessageToTopic(id, message);
                resp.sendRedirect("showTopic?topicId=" + topicId);
            } catch (NumberFormatException e) {
                resp.sendRedirect("listTopics");
            }
        } else {
            resp.sendRedirect("listTopics");
        }
    }
}
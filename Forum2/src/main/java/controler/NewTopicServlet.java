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
import model.Topic;
import model.User;

@WebServlet("/newTopic")
public class NewTopicServlet extends HttpServlet {
    private ForumService forumService = new ForumService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Chuyển đến trang newTopic.jsp
        req.getRequestDispatcher("newTopic.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        String title = req.getParameter("title");
        String content = req.getParameter("content");

        // Tạo topic mới
        Long newId = System.currentTimeMillis(); // Sử dụng thời gian làm ID
        Topic topic = new Topic(newId, title, Calendar.getInstance(), content, user, null);
        forumService.addTopic(topic);

        resp.sendRedirect("listTopics");
    }
}
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.User" %>
<%@ page import="model.Topic" %>
<%@ page import="model.Message" %>
<%@ page import="java.util.Stack" %>
<%
    User user = (User) session.getAttribute("user");
    Topic topic = (Topic) request.getAttribute("topic");
    if (topic == null) {
        response.sendRedirect("listTopics");
        return;
    }
    Stack<Message> messages = topic.getMessages();
%>
<html>
<head>
    <title><%= topic.getTitle() %></title>
</head>
<body>
    <div>
        <% if (user != null) { %>
            Chào <%= user.getUserName() %> | <a href="logout">Thoát</a>
        <% } else { %>
            <a href="login.jsp">Đăng nhập</a>
        <% } %>
    </div>
    <h1>Chủ đề: <%= topic.getTitle() %></h1>
    <%
        Message latestMessage = topic.getNewMessage();
        if (latestMessage != null) {
    %>
        <p>Bài mới nhất gửi <%= String.format("%1$tm-%1$td-%1$tY %1$tI:%1$tM %1$Tp", latestMessage.getCreatedTime()) %>, do <%= latestMessage.getCreator().getUserName() %> gửi. <%= messages.size() %> hồi âm.</p>
    <%
        }
    %>
    <%
        for (Message message : messages) {
    %>
        <div>
            <p><%= String.format("%1$tm-%1$td-%1$tY %1$tI:%1$tM %1$Tp", message.getCreatedTime()) %></p>
            <p><strong><%= message.getCreator().getUserName() %></strong> <strong><%= message.getTitle() %></strong> 
            <% if (user != null) { %>
                <a href="replyTopic?topicId=<%= topic.getEntryId() %>">Trả lời</a>
            <% } %>
            </p>
            <p><%= message.getContent() %></p>
        </div>
        <hr>
    <%
        }
    %>
    <a href="listTopics">Danh sách chủ đề</a>
</body>
</html>
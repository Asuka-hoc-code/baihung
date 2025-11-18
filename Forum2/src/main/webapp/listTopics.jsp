<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.User" %>
<%@ page import="model.Topic" %>
<%@ page import="model.Message" %>
<%@ page import="java.util.List" %>
<%
    User user = (User) session.getAttribute("user");
    List<Topic> topics = (List<Topic>) request.getAttribute("topics");
%>
<html>
<head>
    <title>Danh sách chủ đề</title>
</head>
<body>
    <div>
        <% if (user != null) { %>
            Chào <%= user.getUserName() %> | <a href="logout">Thoát</a>
        <% } else { %>
            <a href="login.jsp">Đăng nhập</a>
        <% } %>
    </div>
    <h1>Diễn đàn: Chuyện học phí và các chính sách hỗ trợ học tập</h1>
    <table border="1">
        <tr>
            <th>Chủ đề</th>
            <th>Hồi âm</th>
        </tr>
        <% for (Topic topic : topics) { 
            Message latestMessage = topic.getNewMessage();
        %>
            <tr>
                <td>
                    <a href="showTopic?topicId=<%= topic.getEntryId() %>"><%= topic.getTitle() %></a>
                    <% if (latestMessage != null) { %>
                        <br>Bài mới nhất by <%= latestMessage.getCreator().getUserName() %>, 
                        <%= String.format("%1$tm-%1$td-%1$tY %1$tI:%1$tM %1$Tp", latestMessage.getCreatedTime()) %>
                    <% } %>
                </td>
                <td><%= topic.getMessages().size() %></td>
            </tr>
        <% } %>
    </table>
    <% if (user != null) { %>
        <a href="newTopic">Gửi bài mới</a>
    <% } %>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    String topicId = (String) request.getAttribute("topicId");
%>
<html>
<head>
    <title>Trả lời</title>
</head>
<body>
    <div>
        Chào <%= user.getUserName() %> | <a href="logout">Thoát</a>
    </div>
    <h1>Trả lời chủ đề</h1>
    <form action="replyTopic" method="post">
        <input type="hidden" name="topicId" value="<%= topicId %>">
        <label for="title">Tiêu đề:</label><br>
        <input type="text" id="title" name="title" value="Re: " required><br>
        <label for="content">Nội dung:</label><br>
        <textarea id="content" name="content" rows="5" cols="30" required></textarea><br>
        <input type="submit" value="Gửi">
        <a href="listTopics">Hủy bỏ</a>
    </form>
</body>
</html>
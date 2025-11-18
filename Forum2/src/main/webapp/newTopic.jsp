<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Bài mới</title>
</head>
<body>
    <div>
        Chào <%= user.getUserName() %> | <a href="logout">Thoát</a>
    </div>
    <h1>Gửi bài mới</h1>
    <form action="newTopic" method="post">
        <label for="title">Tiêu đề:</label><br>
        <input type="text" id="title" name="title" required><br>
        <label for="content">Nội dung:</label><br>
        <textarea id="content" name="content" rows="5" cols="30" required></textarea><br>
        <input type="submit" value="Gửi">
        <a href="listTopics">Hủy bỏ</a>
    </form>
</body>
</html>
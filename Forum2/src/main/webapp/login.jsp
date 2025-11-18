<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
    <h1>Đăng nhập</h1>
    <form action="login" method="post">
        <label for="username">Tên đăng nhập:</label>
        <input type="text" id="username" name="username" required><br>
        <label for="password">Mật khẩu:</label>
        <input type="password" id="password" name="password" required><br>
        <input type="submit" value="Đăng nhập">
    </form>
    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <p style="color: red;"><%= error %></p>
    <%
        }
    %>
</body>
</html>
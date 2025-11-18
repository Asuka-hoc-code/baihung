<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Booking" %>
<%@ page import="java.text.SimpleDateFormat" %>
<html>
<head>
    <title>Xác nhận</title>
    <style>body { font-family: Arial, sans-serif; padding: 20px; }</style>
</head>
<body>
    <h2>Xác nhận đặt tour thành công</h2>
    <%
        // Lấy object booking được gửi từ Servlet
        Booking b = (Booking) request.getAttribute("bookingData");
        
        if (b != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    %>
        <p>Cảm ơn <b><%= b.getCustomer().getName() %></b> đã đặt tour tại hệ thống.</p>
        <hr>
        <h3>Thông tin đặt tour:</h3>
        <ul>
            <li><b>Tour:</b> <%= b.getTour().getDescription() %></li>
            <li><b>Ngày khởi hành:</b> <%= sdf.format(b.getDepartureDate()) %></li>
            <li><b>Số lượng:</b> <%= b.getNoAdults() %> người lớn, <%= b.getNoChildren() %> trẻ em.</li>
        </ul>
        
        <h3>Thông tin liên hệ:</h3>
        <ul>
            <li><b>Email:</b> <%= b.getCustomer().getEmail() %></li>
            <li><b>Địa chỉ:</b> <%= b.getCustomer().getAddress() %></li>
            <li><b>Điện thoại:</b> <%= b.getCustomer().getPhone() %></li>
        </ul>

        <a href="index.jsp">Về trang chủ</a>
    <% } else { %>
        <p>Không có thông tin xác nhận. <a href="index.jsp">Quay lại</a></p>
    <% } %>
</body>
</html>
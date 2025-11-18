<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.*" %>
<html>
<head>
    <title>Đặt Tour</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        .title { font-weight: bold; margin-bottom: 20px; }
        .form-table { width: 100%; max-width: 600px; }
        .form-table td { padding: 5px; vertical-align: top; }
        .label { font-weight: bold; width: 150px; }
        input[type="text"], input[type="email"], input[type="number"] { width: 100%; padding: 5px; }
        .buttons { margin-top: 10px; text-align: center; }
    </style>
</head>
<body>
    <%
        String idStr = request.getParameter("id");
        Tour t = null;
        if (idStr != null) {
            TourService service = new TourService();
            t = service.getTour(Long.parseLong(idStr));
        }
        if (t != null) {
    %>
    
    <div class="title">
        Đặt tour : <%= t.getDescription() %> <%= t.getDays() %>
    </div>

    <form action="bookTour" method="post">
        <input type="hidden" name="tourId" value="<%= t.getId() %>">

        <table class="form-table">
            <tr><td colspan="2"><h4>Thông tin khách hàng</h4></td></tr>
            <tr>
                <td class="label">Họ tên: (*)</td>
                <td><input type="text" name="name" required></td>
            </tr>
            <tr>
                <td class="label">Địa chỉ:</td>
                <td><input type="text" name="address"></td>
            </tr>
            <tr>
                <td class="label">E-mail: (*)</td>
                <td><input type="email" name="email" required></td>
            </tr>
            <tr>
                <td class="label">Điện thoại:</td>
                <td><input type="text" name="phone"></td>
            </tr>

            <tr><td colspan="2"><h4>Thông tin chuyến đi:</h4></td></tr>
            <tr>
                <td class="label">Ngày khởi hành: (*)</td>
                <td>
                    <input type="text" name="departureDate" placeholder="dd/mm/yyyy" required>
                    <br><small>(dd/mm/yyyy)</small>
                </td>
            </tr>
            <tr>
                <td class="label">Số người lớn: (*)</td>
                <td><input type="number" name="adults" min="1" required></td>
            </tr>
            <tr>
                <td class="label">Số trẻ em:</td>
                <td><input type="number" name="children" min="0"></td>
            </tr>
            <tr>
                <td colspan="2" class="buttons">
                    <input type="submit" value="Gửi">
                    <input type="button" value="Hủy" onclick="window.location.href='listTours.jsp'">
                </td>
            </tr>
        </table>
    </form>
    <% } else { out.print("Vui lòng chọn tour từ danh sách."); } %>
</body>
</html>
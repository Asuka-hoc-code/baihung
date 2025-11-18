<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>
<html>
<head>
    <title>Danh sách Tour</title>
    <style>
        body { font-family: Arial, sans-serif; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; font-size: 14px; }
        th { background-color: #e0e0e0; text-align: center; font-weight: bold; }
        /* Style cho các dòng lẻ để dễ nhìn giống hình */
        tr:nth-child(even) { background-color: #f9f9f9; }
        tr:nth-child(odd) { background-color: #ccffff; }
        
        .book-btn { 
            background: linear-gradient(to bottom, #4c9de7 5%, #10559e 100%);
            background-color: #4c9de7;
            border: 1px solid #0b4384;
            color: #ffffff;
            padding: 3px 10px;
            text-decoration: none;
            font-weight: bold;
            font-size: 12px;
            border-radius: 3px;
        }
        a { text-decoration: none; color: #0000EE; }
    </style>
</head>
<body>
    <h3>Các Chương trình DU LỊCH</h3>
    
    <%
        TourService service = new TourService();
        List<Tour> list = service.getAllTours();
        DecimalFormat df = new DecimalFormat("###,###"); // Định dạng tiền tệ
    %>

    <table>
        <tr>
            <th>Chương trình</th>
            <th>Lịch Khởi hành</th>
            <th>Giá</th>
            <th>Đặt</th>
        </tr>
        <% for (Tour t : list) { %>
        <tr>
            <td>
                <a href="tourDetails.jsp?id=<%= t.getId() %>" style="font-weight: bold; text-transform: uppercase;">
                    <%= t.getDescription() %>
                </a>
                <br>
                <span style="font-size: 12px;"><%= t.getDays() %></span>
            </td>
            <td><%= t.getDepartureSchedule() %></td>
            <td style="font-weight: bold; text-align: right;"><%= df.format(t.getPrice()) %></td>
            <td style="text-align: center;">
                <a href="bookingTour.jsp?id=<%= t.getId() %>" class="book-btn">Đặt tour</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>
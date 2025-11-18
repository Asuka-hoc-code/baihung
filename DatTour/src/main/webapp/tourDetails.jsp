<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="model.*"%>
<html>
<head>
<title>Chi tiết Tour</title>
<style>
body {
	font-family: Arial, sans-serif;
	padding: 20px;
}

.header {
	font-weight: bold;
	font-size: 18px;
	margin-bottom: 10px;
}

.info {
	margin-bottom: 20px;
}

.detail-content {
	white-space: pre-line;
	font-size: 14px;
	line-height: 1.5;
}

.btn-dat-tour {
	background-color: #10559e;
	color: white;
	padding: 5px 10px;
	text-decoration: none;
	font-weight: bold;
	font-size: 12px;
}

.back-link {
	float: right;
	font-weight: bold;
	text-transform: uppercase;
	color: blue;
}
</style>
</head>
<body>
	<%
	String idStr = request.getParameter("id");
	if (idStr != null && !idStr.isEmpty()) {
		long id = Long.parseLong(idStr);
		TourService service = new TourService();
		Tour t = service.getTour(id);
		if (t != null) {
	%>
	<div class="header"><%=t.getDescription()%></div>

	<div class="info">
		<b>Số ngày:</b>
		<%=t.getDays()%>. <b>Phương tiện:</b>
		<%=t.getTransportation()%>. <b>Lịch khởi hành:</b>
		<%=t.getDepartureSchedule()%>
	</div>

	<h3>Chương trình chi tiết:</h3>
	<div class="detail-content">
		<%=t.getDetailProgram()%>
	</div>

	<br>
	<a href="bookingTour.jsp?id=<%=t.getId()%>" class="btn-dat-tour">Đặt
		tour</a>

	<br>
	<br>
	<hr>
	<a href="listTours.jsp" class="back-link">CHƯƠNG TRÌNH TOUR</a>
	<%
	} else {
	out.print("Không tìm thấy Tour.");
	}
	} else {
	out.print("ID không hợp lệ.");
	}
	%>
</body>
</html>
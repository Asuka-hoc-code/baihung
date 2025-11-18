package controller;

import model.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bookTour")
public class BookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BookingServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Cấu hình tiếng Việt UTF-8 (QUAN TRỌNG)
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        try {
            // 2. Lấy dữ liệu từ form (bookingTour.jsp)
            String tourIdStr = request.getParameter("tourId");
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            
            String departureDateStr = request.getParameter("departureDate");
            String adultsStr = request.getParameter("adults");
            String childrenStr = request.getParameter("children");

            // 3. Chuyển đổi dữ liệu
            long tourId = Long.parseLong(tourIdStr);
            int adults = Integer.parseInt(adultsStr);
            int children = (childrenStr == null || childrenStr.isEmpty()) ? 0 : Integer.parseInt(childrenStr);

            // Chuyển đổi ngày tháng (dd/MM/yyyy)
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date departureDate = sdf.parse(departureDateStr);

            // 4. Gọi Service để xử lý logic
            TourService service = new TourService();
            Tour tour = service.getTour(tourId); // Lấy thông tin tour đã chọn
            
            // Tạo đối tượng Customer
            Customer customer = new Customer(name, address, email, phone);
            
            // Tạo đối tượng Booking
            Booking booking = new Booking(customer, tour, departureDate, adults, children);

            // Lưu vào "CSDL"
            service.saveCustomer(customer);
            service.saveBooking(booking);

            // 5. Chuyển hướng sang trang xác nhận (confirm.jsp)
            // Lưu object booking vào request để trang kia hiển thị
            request.setAttribute("bookingData", booking);
            request.getRequestDispatcher("confirm.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h3>Có lỗi xảy ra: " + e.getMessage() + "</h3>");
        }
    }
}
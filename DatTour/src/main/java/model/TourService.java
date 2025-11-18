package model;

import java.util.ArrayList;
import java.util.List;

public class TourService {
    // Giả lập cơ sở dữ liệu bằng List tĩnh
    private static List<Tour> tours = new ArrayList<>();

    static {
        // Dữ liệu mẫu giống như trong hình
        tours.add(new Tour(1, "NHA TRANG", "2 ngày 2 đêm", "Tàu hỏa", "Tối thứ 6 và CN", 1540000, 
            "Ngày 01 (Thứ bảy): PHỐ BIỂN NHA TRANG\nTham quan suối Hoa Lan. Khám phá Mê Cung Trận Đồ...\n\nNgày 02 (Chủ nhật): NHA TRANG - SÀI GÒN (tàu lửa)\nTham quan Tháp Bà Ponagar..."));
        
        tours.add(new Tour(2, "PHÚ QUỐC (Khuyến mãi mùa hè)", "3 ngày 2 đêm", "Máy bay", "Hằng ngày", 1595000, 
            "Chương trình chi tiết Phú Quốc đang cập nhật..."));
            
        tours.add(new Tour(3, "CÔN ĐẢO", "3 ngày 2 đêm", "Tàu cao tốc", "Hằng ngày", 1345000, 
            "Chương trình chi tiết Côn Đảo đang cập nhật..."));
            
        tours.add(new Tour(4, "PHAN THIẾT - MŨI NÉ", "2 ngày 1 đêm", "Xe du lịch", "Thứ 7 mỗi tuần", 1250000, 
            "Chương trình chi tiết Phan Thiết đang cập nhật..."));
            
        tours.add(new Tour(5, "ĐÀ LẠT - ĐỒI MỘNG MƠ", "4 ngày 3 đêm", "Xe du lịch", "Thứ 7 mỗi tuần", 1320000, 
            "Chương trình chi tiết Đà Lạt đang cập nhật..."));
            
        tours.add(new Tour(6, "BUÔN MA THUỘT - GIA LAI - KOMTUM", "4 ngày 3 đêm", "Xe du lịch", "Định kỳ", 1790000, 
            "Chương trình chi tiết Tây Nguyên đang cập nhật..."));
    }

    // Phương thức trả về danh sách tất cả các tour
    public List<Tour> getAllTours() {
        return tours;
    }

    // Phương thức tìm tour theo ID
    public Tour getTour(long id) {
        for (Tour t : tours) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    // Phương thức lưu Customer (Giả lập in ra console)
    public void saveCustomer(Customer customer) {
        System.out.println("--- Đã lưu Customer vào CSDL ---");
        System.out.println("Tên: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
    }

    // Phương thức lưu Booking (Giả lập in ra console)
    public void saveBooking(Booking booking) {
        System.out.println("--- Đã lưu Booking vào CSDL ---");
        System.out.println("Tour: " + booking.getTour().getDescription());
        System.out.println("Ngày đi: " + booking.getDepartureDate());
        System.out.println("Người lớn: " + booking.getNoAdults());
    }
}
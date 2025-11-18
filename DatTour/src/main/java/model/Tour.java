package model;

public class Tour {
    private long id;
    private String description; // Tên tour
    private String days;        // Số ngày
    private String transportation; // Phương tiện
    private String departureSchedule; // Lịch khởi hành
    private double price;       // Giá
    private String detailProgram; // Chi tiết chương trình (cho câu 2)

    // Constructor không tham số
    public Tour() {
    }

    // Constructor đầy đủ
    public Tour(long id, String description, String days, String transportation, String departureSchedule, double price, String detailProgram) {
        this.id = id;
        this.description = description;
        this.days = days;
        this.transportation = transportation;
        this.departureSchedule = departureSchedule;
        this.price = price;
        this.detailProgram = detailProgram;
    }

    // --- Getter và Setter ĐẦY ĐỦ ---
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public String getDepartureSchedule() {
        return departureSchedule;
    }

    public void setDepartureSchedule(String departureSchedule) {
        this.departureSchedule = departureSchedule;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetailProgram() {
        return detailProgram;
    }

    public void setDetailProgram(String detailProgram) {
        this.detailProgram = detailProgram;
    }
}
package model;
import java.util.Date;

public class Booking {
    private long id;
    private Customer customer;
    private Tour tour; // Thêm biến Tour để hiển thị thông tin xác nhận
    private Date departureDate;
    private int noAdults;
    private int noChildren;

    public Booking() {
    }

    public Booking(Customer customer, Tour tour, Date departureDate, int noAdults, int noChildren) {
        this.customer = customer;
        this.tour = tour;
        this.departureDate = departureDate;
        this.noAdults = noAdults;
        this.noChildren = noChildren;
    }

    // --- Getter và Setter ĐẦY ĐỦ ---
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public int getNoAdults() {
        return noAdults;
    }

    public void setNoAdults(int noAdults) {
        this.noAdults = noAdults;
    }

    public int getNoChildren() {
        return noChildren;
    }

    public void setNoChildren(int noChildren) {
        this.noChildren = noChildren;
    }
}
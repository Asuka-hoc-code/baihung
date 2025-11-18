package service;
import model.*;
import java.util.*;

public class AuctionService {
    private static List<AuctionItem> items = new ArrayList<>();
    private static List<User> users = new ArrayList<>();

    static {
        items.add(new AuctionItem(1L, "Máy chụp hình Canon IXY 910 IS (8.0 MP)", 100000, 10000));
        items.add(new AuctionItem(2L, "Laptop Acer 3680-2682 hàng xách tay", 3000000, 50000));
        items.add(new AuctionItem(3L, "Máy nghe nhạc APPLE IPHONE 16GB", 500000, 20000));
        items.add(new AuctionItem(4L, "Nước hoa Embrace Him - 8057", 150000, 5000));

        users.add(new User("hoangnv", "hoangnv", "hoangnv@gmail.com", null, null, null));
    }

    public List<AuctionItem> getAllAuctionItems() {
        return items;
    }

    public AuctionItem getAuctionItem(Long id) {
        for (AuctionItem item : items) {
            if (item.getId().equals(id)) return item;
        }
        return null;
    }

    public User authenticateUser(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public void bid(User user, AuctionItem item, double amount) {

        Bid newBid = new Bid(user, item, amount, Calendar.getInstance());
        item.addBid(newBid);
    }
}
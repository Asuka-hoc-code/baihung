package model;

import java.util.*;

public class ForumService {
    private Map<String, User> users;
    private List<Category> categories;

    public ForumService() {
        users = new HashMap<>();
        categories = new ArrayList<>();

        // Tạo một số user mẫu
        User user1 = new User("chuotcon", "chuotcon", "chuotcon@example.com", new Date());
        User user2 = new User("leb", "leb", "leb@example.com", new Date());
        User user3 = new User("liss", "liss", "liss@example.com", new Date());
        User user4 = new User("dt03", "dt03", "dt03@example.com", new Date());
        User user5 = new User("GSKH", "GSKH", "GSKH@example.com", new Date());
        User user6 = new User("doctorQ", "doctorQ", "doctorQ@example.com", new Date());

        users.put(user1.getUserName(), user1);
        users.put(user2.getUserName(), user2);
        users.put(user3.getUserName(), user3);
        users.put(user4.getUserName(), user4);
        users.put(user5.getUserName(), user5);
        users.put(user6.getUserName(), user6);

        // Tạo một category mẫu
        Category category = new Category("Chuyện học phí và các chính sách hỗ trợ học tập");

        // Tạo một số topic mẫu
        Calendar cal = Calendar.getInstance();
        cal.set(2007, Calendar.SEPTEMBER, 24, 14, 53, 0);
        Topic topic1 = new Topic(1L, "Xung quanh dự thảo của Đề án tăng học phí", cal, "Nội dung topic 1", user5, category);

        cal = Calendar.getInstance();
        cal.set(2007, Calendar.OCTOBER, 9, 21, 27, 0);
        Topic topic2 = new Topic(2L, "Một số mốc quan trọng đề án \"Tăng học phí\"", cal, "Nội dung topic 2", user4, category);

        cal = Calendar.getInstance();
        cal.set(2007, Calendar.OCTOBER, 29, 12, 23, 0);
        Topic topic3 = new Topic(3L, "Học phí trái buổi", cal, "Nội dung topic 3", user3, category);

        cal = Calendar.getInstance();
        cal.set(2008, Calendar.JANUARY, 5, 5, 49, 0);
        Topic topic4 = new Topic(4L, "Thủ tướng: Trường ĐH tự quyết mức học phí", cal, "Nội dung topic 4", user2, category);

        cal = Calendar.getInstance();
        cal.set(2008, Calendar.FEBRUARY, 23, 19, 1, 0);
        Topic topic5 = new Topic(5L, "Chuyện học phí!!!", cal, "Nội dung topic 5", user1, category);

        // Thêm các topic vào category
        category.addTopic(topic1);
        category.addTopic(topic2);
        category.addTopic(topic3);
        category.addTopic(topic4);
        category.addTopic(topic5);

        // Thêm một số message mẫu cho topic5 (Chuyện học phí!!!)
        cal = Calendar.getInstance();
        cal.set(2007, Calendar.DECEMBER, 8, 4, 45, 0);
        Message message1 = new Message(1L, "Chuyện học phí!!!", "Trả lời: Tham gia 02-02-2008 Từ lớp mẫu giáo đến lớp 12-trường công-Tại sao lại phải đóng học phí?!", cal, user6);

        cal = Calendar.getInstance();
        cal.set(2008, Calendar.FEBRUARY, 23, 19, 1, 0);
        Message message2 = new Message(2L, "Re: Chuyện học phí!!!", "Thưa anh (chị) em muôn hỏi là sinh viên dân tộc thiểu số có được miễn giảm học phí hay không? Và những yêu cầu gì đối với sinh viên dân tộc thiểu số để được miễn giảm học phí? Em cảm ơn anh (chị) Ngọc Linh", cal, user1);

        topic5.addMessage(message1);
        topic5.addMessage(message2);

        // Thêm category vào danh sách
        categories.add(category);
    }

    public User checkUser(String name, String password) {
        User user = users.get(name);
        if (user != null && user.verify(name, password)) {
            return user;
        }
        return null;
    }

    public List<Topic> getTopics() {
        List<Topic> allTopics = new ArrayList<>();
        for (Category category : categories) {
            allTopics.addAll(category.getTopics());
        }
        // Sắp xếp các topic theo thời gian tạo? (nếu cần)
        return allTopics;
    }

    public Topic getTopicById(Long id) {
        for (Category category : categories) {
            for (Topic topic : category.getTopics()) {
                if (topic.getEntryId().equals(id)) {
                    return topic;
                }
            }
        }
        return null;
    }

    public void addTopic(Topic topic) {
        // Giả sử thêm topic vào category đầu tiên
        if (!categories.isEmpty()) {
            categories.get(0).addTopic(topic);
        }
    }

    public void addMessageToTopic(Long topicId, Message message) {
        Topic topic = getTopicById(topicId);
        if (topic != null) {
            topic.addMessage(message);
        }
    }
}
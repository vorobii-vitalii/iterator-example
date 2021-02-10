import java.util.ArrayList;
import java.util.List;

public class User {
    private final String userName;
    private final List<User> friends = new ArrayList<>();

    public User(String userName) {
        this.userName = userName;
    }

    public void addFriend(User friend) {
        friends.add(friend);
    }

    public List<User> getFriends() {
        return new ArrayList<>(friends);
    }

    public String getUserName() {
        return userName;
    }
}

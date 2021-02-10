import java.util.ArrayList;
import java.util.List;

public class UserConnectionsIterator implements NetworkIterator<User> {
    private List<User> currentLevelUsers;
    private int usersIndex = 0;

    public UserConnectionsIterator(List<User> users) {
        currentLevelUsers = new ArrayList<>(users);
    }

    @Override
    public boolean hasNext() {
        return currentLevelUsers != null && !currentLevelUsers.isEmpty();
    }

    @Override
    public User next() {
        final User userToReturn = currentLevelUsers.get(usersIndex++);

        // If the current level is fully traversed, move to lower level
        if (usersIndex == currentLevelUsers.size()) {
            currentLevelUsers = getAllChildren(currentLevelUsers);
            usersIndex = 0;
        }

        return userToReturn;
    }


    private static List<User> getAllChildren(List<User> parentLevel) {
        final List<User> children = new ArrayList<>();

        for (User user : parentLevel) {
            children.addAll(user.getFriends());
        }

        return children;
    }

}

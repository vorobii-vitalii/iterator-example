import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final List<User> users = createUsers();

    @Override
    public List<User> getAll() {
        return users;
    }

    private static List<User> createUsers() {
        User john = new User("John");
        User michael = new User("Michael");
        User julia = new User("Julia");
        User william = new User("William");

        john.addFriend(michael);
        michael.addFriend(julia);
        john.addFriend(william);
        william.addFriend(julia);

        return List.of(john, michael, julia, william);
    }
}

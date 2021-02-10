public class Main {
    private static final UserRepository userRepository = new UserRepositoryImpl();

    public static void main(String[] args) {
        final Network<User> userNetwork = new FacebookNetwork(userRepository);

        final NetworkIterator<User> userIterator = userNetwork.getIterator();

        while (userIterator.hasNext()) {
            var user = userIterator.next();
            System.out.println(user.getUserName());
        }
    }

}

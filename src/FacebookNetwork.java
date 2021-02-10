public class FacebookNetwork implements Network<User> {
    private final UserRepository userRepository;

    public FacebookNetwork(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public NetworkIterator<User> getIterator() {
        var users = userRepository.getAll();
        return new UserConnectionsIterator(users);
    }
}

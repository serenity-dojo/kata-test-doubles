package serenitylabs.tutorials.testdoubles;

public class System {

    private Authoriser authoriser;
    private int activeUsers = 0;

    public System(Authoriser authoriser) {
        this.authoriser = authoriser;
    }

    public void login(String username, String password) {
        if (authoriser.authorise(username, password)) {
            ++activeUsers;
        }
    }

    public int numberOfActiveUsers() {
        return activeUsers;
    }
}

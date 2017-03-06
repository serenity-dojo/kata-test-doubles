package serenitylabs.tutorials.testdoubles.classic;

import org.junit.Test;
import serenitylabs.tutorials.testdoubles.Authoriser;
import serenitylabs.tutorials.testdoubles.System;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenUsingAMock {

    @Test
    public void we_want_to_move_the_test_logic_from_the_test_to_the_mock_object() {
        AcceptingAuthoriserVerificationMock mock = new AcceptingAuthoriserVerificationMock();
        System system = new System(mock);

        system.login("bob", "SecretPassword");

        assertThat(mock.verify()).isTrue();
    }

    static class AcceptingAuthoriserVerificationMock implements Authoriser {
        private boolean authoriseWasCalled = false;
        private boolean loggedInAsBob = false;

        @Override
        public Boolean authorise(String username, String password) {
            authoriseWasCalled = true;
            loggedInAsBob = "bob".equalsIgnoreCase(username);

            return true;
        }

        public boolean verify() {
            return authoriseWasCalled && loggedInAsBob;
        }
    }
}

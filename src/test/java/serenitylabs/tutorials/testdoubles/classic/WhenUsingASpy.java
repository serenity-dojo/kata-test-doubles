package serenitylabs.tutorials.testdoubles.classic;

import org.junit.Test;
import serenitylabs.tutorials.testdoubles.Authoriser;
import serenitylabs.tutorials.testdoubles.System;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenUsingASpy {

    @Test
    public void we_want_to_ensure_that_the_spy_was_called() {
        AcceptingAuthoriserSpy spy = new AcceptingAuthoriserSpy();
        System system = new System(spy);

        system.login("bob", "SecretPassword");

        assertThat(spy.authoriseWasCalled).isTrue();
    }

    static class AcceptingAuthoriserSpy implements Authoriser {
        public boolean authoriseWasCalled = false;

        @Override
        public Boolean authorise(String username, String password) {
            authoriseWasCalled = true;
            return true;
        }
    }
}

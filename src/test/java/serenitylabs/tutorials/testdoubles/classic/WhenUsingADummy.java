package serenitylabs.tutorials.testdoubles.classic;

import org.junit.Test;
import serenitylabs.tutorials.testdoubles.Authoriser;
import serenitylabs.tutorials.testdoubles.System;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenUsingADummy {

    @Test
    public void we_do_not_worry_about_the_value_it_returns_because_we_know_it_will_never_be_used() {
        System system = new System(dummyAuthoriser());

        assertThat(system.numberOfActiveUsers()).isEqualTo(0);
    }

    @Test(expected=NullPointerException.class)
    public void we_can_make_it_return_a_null_so_that_it_does_not_get_used_accidentally() {
        System system = new System(dummyAuthoriser());

        system.login("bob", "SecretPassword");
    }

    private Authoriser dummyAuthoriser() {
        return (username, password) -> null;
    }
}

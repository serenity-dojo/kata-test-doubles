package serenitylabs.tutorials.testdoubles.classic;

import org.junit.Test;
import serenitylabs.tutorials.testdoubles.Authoriser;
import serenitylabs.tutorials.testdoubles.System;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenUsingAStub {

    @Test
    public void we_want_to_control_the_returned_value_to_make_the_system_under_test_accept_the_login_attempt() {
        System system = new System(acceptingAuthoriser());

        system.login("bob", "SecretPassword");

        assertThat(system.numberOfActiveUsers()).isEqualTo(1);
    }

    @Test
    public void we_want_to_control_the_returned_value_to_make_the_system_under_test_reject_the_login_attempt() {
        System system = new System(rejectingAuthoriser());

        system.login("bob", "SecretPassword");

        assertThat(system.numberOfActiveUsers()).isEqualTo(0);
    }

    private Authoriser acceptingAuthoriser() {
        return (username, password) -> true;
    }

    private Authoriser rejectingAuthoriser() {
        return (username, password) -> false;
    }
}

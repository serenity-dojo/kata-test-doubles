package serenitylabs.tutorials.stockbroker;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ClientTest {

    @Test
    public void should_be_able_to_place_an_empty_order() throws Exception {

        Client client = new Client(null, null);

        assertThat(client.place("")).isEqualTo("Buy: USD 0.00, Sell: USD 0.00");
    }

    @Test
    @Ignore("Implement me, please ...")
    public void should_be_able_to_place_a_single_order() throws Exception {

        Client client = new Client(null, null);

        assertThat(client.place("GOOG 300 829.08 B")).isEqualTo("Buy: USD 248724.00, Sell: USD 0.00");
    }
}

package serenitylabs.tutorials.stockbroker.exchange;

import static java.lang.String.format;

public class StockExchange {
    public Boolean execute(Order order) {
        throw new RuntimeException(
                format("You've just executed the following order: %s. " +
                        "Try to use a test double instead of the real thing.", order)
        );
    }
}

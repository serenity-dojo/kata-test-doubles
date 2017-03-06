package serenitylabs.tutorials.stockbroker;

import serenitylabs.tutorials.stockbroker.parser.OrderParser;

public class Client {
    private final StockBroker broker;
    private final OrderParser parser;

    public Client(StockBroker broker, OrderParser parser) {
        this.broker = broker;
        this.parser = parser;
    }

    public String place(String orders) {

        // looks like we're missing something here ;-)

        return "Buy: USD 0.00, Sell: USD 0.00";
    }
}

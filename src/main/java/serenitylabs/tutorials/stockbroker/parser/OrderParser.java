package serenitylabs.tutorials.stockbroker.parser;

import serenitylabs.tutorials.stockbroker.exchange.Order;

import java.util.List;

public interface OrderParser {
    List<Order> parse(String orders);
}

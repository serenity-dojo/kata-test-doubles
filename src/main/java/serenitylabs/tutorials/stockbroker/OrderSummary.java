package serenitylabs.tutorials.stockbroker;

import org.joda.money.Money;
import serenitylabs.tutorials.stockbroker.exchange.Order;

import java.util.List;

public interface OrderSummary {
    Money buyTotal();
    Money sellTotal();
    List<Order> failedOrders();
}

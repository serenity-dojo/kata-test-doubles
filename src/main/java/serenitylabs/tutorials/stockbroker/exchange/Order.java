package serenitylabs.tutorials.stockbroker.exchange;

import org.joda.money.Money;

import java.util.StringJoiner;

public class Order {
    private final String stockSymbol;
    private final int quantity;
    private final Money price;
    private final OrderType orderType;

    public Order(String stockSymbol, int quantity, Money price, OrderType orderType) {
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.orderType = orderType;
    }

    public String symbol() {
        return stockSymbol;
    }

    public Money price() {
        return price;
    }

    public int quantity() {
        return quantity;
    }

    public OrderType type() { return orderType; }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("stockSymbol=" + stockSymbol)
                .add("quantity=" + quantity)
                .add("price=" + price)
                .add("orderType=" + orderType)
                .toString();
    }

}

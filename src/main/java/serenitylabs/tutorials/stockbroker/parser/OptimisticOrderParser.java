package serenitylabs.tutorials.stockbroker.parser;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import serenitylabs.tutorials.stockbroker.exchange.Order;
import serenitylabs.tutorials.stockbroker.exchange.OrderType;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;

public class OptimisticOrderParser implements OrderParser {
    static final private String Buy      = "B";
    static final private String Sell     = "S";

    static final private String Symbol   = "[^\\s]+";
    static final private String Price    = "\\d+\\.\\d{2}";
    static final private String Quantity = "\\d+";
    static final private String Type     = format("%s|%s", Buy, Sell);

    static final private Pattern Order_Pattern = Pattern.compile(
        format("(%s)\\s(%s)\\s(%s)\\s(%s),?", Symbol, Quantity, Price, Type)
    );

    private final CurrencyUnit unit;

    public OptimisticOrderParser(CurrencyUnit unit) {
        this.unit = unit;
    }

    public List<Order> parse(String orders) {
        return MatcherStream.find(Order_Pattern, orders)
                .map(matched -> new Order(
                        matched.group(1),
                        parseInt(matched.group(2)),
                        Money.of(unit, parseDouble(matched.group(3))),
                        OrderType.bySymbol(matched.group(4))
                ))
                .collect(Collectors.toList());
    }
}

package serenitylabs.tutorials.stockbroker.exchange;

public enum OrderType {
    Buy("B"),
    Sell("S");

    private final String symbol;

    OrderType(String typeSymbol) {
        this.symbol = typeSymbol;
    }

    public static OrderType bySymbol(String symbol){
        for(OrderType type : values()){
            if( type.symbol.equals(symbol)){
                return type;
            }
        }
        return null;
    }
}

package tictactoe;

enum Symbol {
    EMPTY(" "),
    CROSS("X"),
    CIRCLE("O");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}

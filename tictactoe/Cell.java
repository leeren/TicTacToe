package tictactoe;

class Cell { 

    private Symbol s;

    Cell() {
        s = Symbol.EMPTY;
    }

    Symbol getSymbol() {
        return s;
    }

    void setSymbol(Symbol s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s.toString();
    }
}


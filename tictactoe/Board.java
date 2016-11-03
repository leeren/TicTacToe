package tictactoe;

public class Board { 

    public static final int SIZE = 3;

    private Cell[][] board;

    public Board() {
        board = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    void place(int x, int y, Symbol s) {
        board[x][y].setSymbol(s);
    }

    Cell get(int x, int y) {
        return board[x][y];
    }

    Symbol getSymbol(int x, int y) {
        return get(x, y).getSymbol();
    }

    boolean isValid(int x, int y) {
        return inBounds(x) && inBounds(y) && board[x][y].getSymbol() == Symbol.EMPTY;
    }

    private boolean inBounds(int i) {
        return i >=0 && i < SIZE;
    }

    public void print() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j].getSymbol());
            }
            System.out.println();
        }
    }
    
}


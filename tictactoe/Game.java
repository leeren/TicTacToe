package tictactoe;

public class Game { 

    private Board board;
    private Player oPlayer;
    private Player xPlayer;
    private Player currPlayer;
    private int moves;

    public Game() {
        this.board = new Board();
        this.oPlayer = new Player(Symbol.CIRCLE, board);
        this.xPlayer = new Player(Symbol.CROSS, board);
        this.currPlayer = xPlayer;
        this.moves = 0;
    }

    public void play() {
        while (true) {
            int[] move = currPlayer.makeMove();
            board.print();
            moves++;
            int x = move[0];
            int y = move[1];
            if (isTie()) {
                System.out.println(Utils.MESSAGE_TIE);
                return;
            } 
            if (hasWon(x, y)) {
                System.out.format("Player %s has won!", currPlayer.getSymbol());
                return;
            }
            togglePlayer();
        }

    }

    public void togglePlayer() {
        this.currPlayer = currPlayer == xPlayer ? oPlayer : xPlayer;
    }

    boolean hasWon(int x, int y) {
        return checkRow(x) || checkCol(y) || checkDiag(x, y) || checkOtherDiag(x, y);

    }

    boolean isTie() {
        return moves == (board.SIZE * board.SIZE);
    }

    boolean checkRow(int x) {
        for (int i = 0; i < board.SIZE; i++) {
            if (board.getSymbol(x, i) != currPlayer.getSymbol()) {
                return false;
            }
        }
        return true;
    }

    boolean checkCol(int y) {
        for (int i = 0; i < board.SIZE; i++) {
            if (board.getSymbol(i, y) != currPlayer.getSymbol()) {
                return false;
            }
        }
        return true;
    }

    boolean checkDiag(int x, int y) {
        if (!(x == y)) {
            return false;
        }
        for (int i = 0; i < board.SIZE; i++) {
            if (board.getSymbol(i, i) != currPlayer.getSymbol()) {
                return false;
            }
        }
        return true;
    }

    boolean checkOtherDiag(int x, int y) {
        if (!(x + y == board.SIZE - 1)) {
            return false;
        }
        for (int i = 0; i < board.SIZE; i++) {
            if (board.getSymbol(i, board.SIZE - 1 - i) != currPlayer.getSymbol()) {
                return false;
            }
        }
        return true;
    }
}

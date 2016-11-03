package tictactoe;

import java.util.Scanner;

public class Player { 

    private Symbol s;
    private Board board;
    private Scanner in;

    public Player(Symbol s, Board board) {
        this.s = s;
        this.board = board;
        this.in = new Scanner(System.in);
    }

    public int[] makeMove() {
        boolean valid = false;
        int[] move = new int[2];
        do {
            System.out.format("Player %s, make your move!", s);
            System.out.println(Utils.MESSAGE_ENTER_X);
            int x = in.nextInt();
            System.out.println(Utils.MESSAGE_ENTER_Y);
            int y = in.nextInt();
            valid = board.isValid(x, y);
            if (valid) {
                System.out.println(Utils.MESSAGE_VALID_MOVE);
                board.place(x, y, s);
                move[0] = x;
                move[1] = y;
            } else {
                System.out.println(Utils.MESSAGE_INVALID_MOVE);
            }
        } while (!valid);
        return move;
    }

    public Symbol getSymbol() {
        return this.s;
    }
}


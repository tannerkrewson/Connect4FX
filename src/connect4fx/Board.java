package connect4fx;

public class Board {

    protected int chipDiam;
    protected BoardSpace[][] board = new BoardSpace[7][6];

    public Board(int cs) {
        chipDiam = cs;
    }
}

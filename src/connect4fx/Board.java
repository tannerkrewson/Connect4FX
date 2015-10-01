package connect4fx;

import javafx.scene.paint.Color;

public class Board {

    protected int chipDiam;
    protected BoardSpace[][] board = new BoardSpace[7][6];

    public Board(int cs) {
        chipDiam = cs;
    }

    public void dropChip(Chip c) {
        addChipToArray(c);
    }

    protected void addChipToArray(Chip c) {
        board[c.getXCoord()][c.getYCoord()] = c;
    }
}

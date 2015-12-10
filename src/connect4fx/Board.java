package connect4fx;

public class Board {

    protected int chipDiam;
    protected EmptyCircle[][] board = new EmptyCircle[7][6];

    public Board(int cs) {
        chipDiam = cs;
    }

    public void dropChip(Chip c) {
        addChipToArray(c);
    }

    protected void addChipToArray(Chip c) {
        board[c.getXCoord()][c.getYCoord()] = c;
    }
    
    public int getChipDiam() {
        return chipDiam;
    }
}

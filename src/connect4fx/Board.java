package connect4fx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Board {

    private GraphicsContext gc;
    private int chipSize;
    //private Chip[][] board = new int[7][6];

    public Board(int cs) {
        chipSize = cs;
    }

    public Board(int cs, GraphicsContext b) {
        chipSize = cs;
        gc = b;
    }

    public void drawBoard() {
        //the instance of Board should have been created with a GraphicsContext
        //if we're going to be able to draw it.
        assert gc != null;
        
        //yellow part of board
        gc.setFill(Color.YELLOW);
        gc.fillRect(0, 100, 700, 600);
        
        //white circles
        gc.setFill(Color.WHITE);
        double cpm = chipPosModifier(100, chipSize);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                gc.fillOval((i * 100) + cpm, (j * 100) + 100 + cpm, chipSize, chipSize);
            }
        }
    }

    private double chipPosModifier(int length, int diameter) {
        return (length - diameter) / 2;
    }

}

package connect4fx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Chip extends BoardSpace {

    private Color chipColor;
    private int xCoord;
    private int yCoord;

    public Chip(int x, int y, Color c) {
        xCoord = x;
        yCoord = y;
        chipColor = c;
    }

    public Color getChipColor() {
        return chipColor;
    }

    public void drawChip(GraphicsContext gc, double cpm) {
        gc.setFill(chipColor);
        gc.fillOval((xCoord * 100) + cpm, (yCoord * 100) + 100 + cpm, 80, 80);
    }
    public int getXCoord(){
        return xCoord;
    }
    
    public int getYCoord(){
        return yCoord;
    }
}

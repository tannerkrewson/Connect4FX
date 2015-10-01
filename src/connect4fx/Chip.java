package connect4fx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Chip extends EmptyCircle {

    protected Color color;
    protected int xCoord;
    protected int yCoord;

    public Chip(int x, int y, Color c) {
        xCoord = x;
        yCoord = y;
        color = c;
    }

    public Color getColor() {
        return color;
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    public void setXCoord(int x) {
        xCoord = x;
    }

    public void setYCoord(int y) {
        yCoord = y;
    }
    
    @Override
    public boolean isChip(){
        return true;
    }
}

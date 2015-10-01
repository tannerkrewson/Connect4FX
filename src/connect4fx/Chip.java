package connect4fx;

import javafx.scene.canvas.GraphicsContext;
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

    public void draw(GraphicsContext gc, double cpm) {
        gc.setFill(color);
        gc.fillOval((xCoord * 100) + cpm, (yCoord * 100) + 100 + cpm, 80, 80);
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
    
    public boolean isChip(){
        return true;
    }
}

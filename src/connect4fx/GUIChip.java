package connect4fx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GUIChip extends Chip {

    public GUIChip(int x, int y, Color c) {
        super(x, y, c);
    }
    
    private Circle cir;
    /*
    public void draw(GraphicsContext gc, double cpm) {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 700, 100);
        gc.setFill(color);
        gc.fillOval((xCoord * 100) + cpm, 0 + cpm, 80, 80);
    }*/
    
    public void draw(GUIBoard b) {
       cir = new Circle(this.getXCoord() * (b.getCanvasX() / 7) + (b.getCanvasX() / 14), this.getYCoord() * (b.getCanvasY() / 7) + (b.getCanvasY() / 14) + (b.getCanvasY() / 7), b.getChipDiam() / 2, this.getColor());
       b.addToCanvas(cir);
    }
}

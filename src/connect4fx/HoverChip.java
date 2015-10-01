package connect4fx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class HoverChip extends Chip {

    public HoverChip(int x, int y, Color c) {
        super(x, y, c);
    }
    
    @Override
    public void draw(GraphicsContext gc, double cpm) {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 700, 100);
        gc.setFill(color);
        gc.fillOval((xCoord * 100) + cpm, 0 + cpm, 80, 80);
    }
}

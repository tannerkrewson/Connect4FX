package connect4fx;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainBoard extends Board {

    private double canvasX, canvasY;
    private GraphicsContext gc;

    public MainBoard(int cs) {
        super(cs);
    }

    public void createWindow(Stage primaryStage) {
        primaryStage.setTitle("Connect4FX");
        Group root = new Group();
        Canvas canvas = new Canvas(700, 700);
        gc = canvas.getGraphicsContext2D();
        Canvas temp = gc.getCanvas();
        canvasX = temp.getWidth();
        canvasY = temp.getHeight();
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void drawBoard() {
        //the instance of Board should have been created with a GraphicsContext
        //if we're going to be able to draw it.
        assert gc != null;

        //because we're assuming the chip boxes are sqaures
        assert canvasX == canvasY;

        //width of a single square on the board
        double sw = canvasX / 7;

        //yellow part of board
        gc.setFill(Color.YELLOW);
        //leave room for hovering chips
        gc.fillRect(0, sw, canvasX, canvasY - sw);

        //white circles
        gc.setFill(Color.WHITE);
        double cpm = chipPosModifier(100, chipDiam);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                gc.fillOval(getChipXPos(i), getChipYPos(j), chipDiam, chipDiam);
            }
        }
    }

    public boolean dropChip(int x, int y, Color c) {
        Chip tempChip = new Chip(x, y, c);
        tempChip.drawChip(gc, chipPosModifier(100, chipDiam));
        board[x][y] = tempChip;
        return true;
    }

    private double chipPosModifier(double length, int diameter) {
        return (length - diameter) / 2;
    }

    private double getChipXPos(int column) {
        return (column * canvasX / 7) + chipPosModifier(canvasX / 7, chipDiam);
    }

    private double getChipYPos(int row) {
        return (row * canvasY / 7) + chipPosModifier(canvasY / 7, chipDiam) + (canvasY / 7);
    }
}

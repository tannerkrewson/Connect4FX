package connect4fx;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainBoard extends Board {

    private double canvasX, canvasY;
    private Canvas can;
    private GraphicsContext gc;

    public MainBoard(int cs) {
        super(cs);
    }

    public void createWindow(Stage primaryStage) {
        primaryStage.setTitle("Connect4FX");
        Group root = new Group();
        can = new Canvas(700, 700);
        gc = can.getGraphicsContext2D();
        canvasX = can.getWidth();
        canvasY = can.getHeight();
        root.getChildren().add(can);
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

    @Override
    public void dropChip(Chip c) {
        c.drawChip(gc, chipPosModifier(100, chipDiam));
    }

    public void waitForUserToClick() {
        can.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        dropChip(new Chip((int) (e.getX() / 100), 0, Color.RED));
                    }
                });
    }

    public void enableHoverChip() {
        HoverChip hoverChip = new HoverChip(0, 0, Color.PURPLE);
        can.addEventHandler(MouseEvent.MOUSE_MOVED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        int mouseColumn = (int) (e.getX() / 100);
                        if (hoverChip.getXCoord() != mouseColumn){
                            hoverChip.setXCoord(mouseColumn);
                            hoverChip.drawChip(gc, chipPosModifier(canvasY / 7, chipDiam));
                        }
                    }
                });
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

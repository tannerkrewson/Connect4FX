package connect4fx;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainBoard extends Board {

    private double canvasX, canvasY;
    private Pane canvas;

    public MainBoard(int cs) {
        super(cs);
    }

    public void createWindow(Stage primaryStage, double xSize, double ySize) {
        Group root = new Group();
        canvasX = xSize;
        canvasY = ySize;
        Scene scene = new Scene(root, canvasX, canvasY);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect4FX");

        canvas = new Pane();
        canvas.setPrefSize(canvasX, canvasY);
        VBox vb = new VBox();
        vb.getChildren().add(canvas);
        scene.setRoot(vb);
        primaryStage.show();
    }

    public void drawBoard() {
        //the instance of Board should have been created with a GraphicsContext
        //if we're going to be able to draw it.
        assert canvas != null;

        //because we're assuming the chip boxes are sqaures
        assert canvasX == canvasY;

        //width of a single square on the board
        double sw = canvasX / 7;

        //yellow part of board, leave room for hovering chips
        Rectangle board = new Rectangle(0, 100, 700, 600);
        board.setFill(Color.YELLOW);
        canvas.getChildren().add(board);

        //white circles
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                canvas.getChildren().add(new Circle(getChipXPos(i), getChipYPos(j) + 100, chipDiam / 2, Color.WHITE));
            }
        }
    }

    @Override
    public void dropChip(Chip c) {
        draw(c);
        super.dropChip(c);
    }

    public void draw(Chip c) {
        canvas.getChildren().add(new Circle(c.getXCoord() * (canvasX / 7) + (canvasX / 14), c.getYCoord() * (canvasY / 7) + (canvasY / 14) + (canvasY / 7), chipDiam / 2, c.getColor()));
    }

    public void waitForUserToClick() {
        EventHandler eh = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                dropChip(new Chip((int) (e.getX() / 100), 0, Color.RED));
                disableUserInput();
                disableHoverChip();
            }
        };
        canvas.setOnMouseClicked(eh);
    }
    
    public void disableUserInput(){
        canvas.setOnMouseClicked(null);
    }

    public void enableHoverChip() {
        HoverChip hoverChip = new HoverChip(0, -1, this.currentTurnColor());
        EventHandler eh = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                int mouseColumn = (int) (e.getX() / 100);
                if (hoverChip.getXCoord() != mouseColumn) {
                    //draw white rect to remove previous hover chip
                    Rectangle board = new Rectangle(0, 0, 700, 100);
                    board.setFill(Color.WHITE);
                    canvas.getChildren().add(board);
                    hoverChip.setXCoord(mouseColumn);
                    draw(hoverChip);
                }
            }
        };
        canvas.setOnMouseMoved(eh);
    }
    
    public void disableHoverChip(){
        canvas.setOnMouseMoved(null);
    }

    public Color currentTurnColor() {
        return Color.BLUE;
    }

    private double getChipXPos(int column) {
        return (column * canvasX / 7) + canvasX / 14;
    }

    private double getChipYPos(int row) {
        return (row * canvasY / 7) + canvasX / 14;
    }
}

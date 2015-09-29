package connect4fx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Connect4FX extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Connect4FX");
        Group root = new Group();
        Canvas canvas = new Canvas(700, 700);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawBoard(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void drawBoard(GraphicsContext gc) {
        gc.setFill(Color.YELLOW);
        gc.fillRect(0, 100, 700, 600);
        gc.setFill(Color.WHITE);
        double cpm = chipPosModifier(100, 80);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                gc.fillOval((i * 100) + cpm, (j * 100) + 100 + cpm, 80, 80);
            }
        }
    }

    private double chipPosModifier(int length, int diameter) {
        return (length - diameter) / 2;
    }
}

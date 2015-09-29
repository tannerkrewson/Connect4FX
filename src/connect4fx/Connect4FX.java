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
        Board main = new Board(80, gc);
        main.drawBoard();
        boolean t = main.dropChip(0, 0, Color.RED);
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
}

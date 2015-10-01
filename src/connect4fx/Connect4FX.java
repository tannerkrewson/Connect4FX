package connect4fx;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Connect4FX extends Application {

    @Override
    public void start(Stage primaryStage) {
        MainBoard main = new MainBoard(80);
        main.createWindow(primaryStage);
        main.drawBoard();
        boolean t = main.dropChip(0, 0, Color.RED);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

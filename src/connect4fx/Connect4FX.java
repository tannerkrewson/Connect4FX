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
        Chip toDrop = new Chip(0,0, Color.BLUE);
        main.dropChip(toDrop);
        main.waitForUserToClick();
        main.enableHoverChip();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

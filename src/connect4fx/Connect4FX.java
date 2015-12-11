package connect4fx;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Connect4FX extends Application {

    @Override
    public void start(Stage primaryStage) {
        GUIBoard main = new GUIBoard(80);
        main.createWindow(primaryStage, 700, 700);
        main.drawBoard();
        GUIChip toDrop = new GUIChip(2,0, Color.BLUE);
        main.dropChip(toDrop);
        //toDrop.move(x, y, main);
        int i = 0;
        do
        { toDrop.move(0,1, main);
            i++;
        }
        while (i<100);
        
        
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

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;
/*
    K = Number of Islands
    F = First Position in the N(th) place
    J = First Position in the K(th) place

    N = Number of Places in Each Island
    M = Number of Relations Available between Places in each Island
    S = Number of the place With aeroplanes in each Island
    T = Number of the place which is Going to be Robbed

Next M Lines:
       U,V : two numbers in each line which indicates that place U is connected To place V
*/

/**
 * @author S.Shayan Daneshvar
 * @author Hashem Pourallahverdi
 */

public class Main extends Application {
    public static void main(String[] args) {
        int numberOfIslands, initialNode, initialIsland;
        Scanner scanner = new Scanner(System.in);
        numberOfIslands = scanner.nextInt();
        initialNode = scanner.nextInt();
        initialIsland = scanner.nextInt();


//        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //todo
    }
}
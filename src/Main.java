import javafx.application.Application;
import javafx.stage.Stage;
import LogicPak.gameBoard;

public class Main extends Application{
    public static void main (String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(gameBoard.layout());
        stage.setTitle("Tic Tac Toe : Extended");
        stage.setResizable(false);
        stage.show();
    }
}

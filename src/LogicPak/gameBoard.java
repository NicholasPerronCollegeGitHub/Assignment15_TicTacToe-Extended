package LogicPak;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class gameBoard {
    public static Scene layout(){
        GridPane grid = new GridPane();
        List<Button> btnmap = new ArrayList<>();
        Label status = new Label("X's turn");
        grid.add(status, 0, 6);
        for(int i = 0; i < 5; i++){
            for(int k = 0; k < 5; k++){
                Button btn = new Button(null);
                btn.setPrefWidth(100);
                btn.setPrefHeight(100);
                btnmap.add(btn);
                btn.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent arg0) {
                        btn.setText(String.valueOf(GameLogic.playTurn()));
                        status.setText(GameLogic.turnLabel(btnmap));
                        status.setText(GameLogic.turnLabel(btnmap));
                        btn.setDisable(true);
                    }
                    
                });

                grid.add(btn, k, i);
            }
        }
        return(new Scene(grid, 500, 500));
    }
}

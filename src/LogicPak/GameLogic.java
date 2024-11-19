package LogicPak;

import java.util.List;

import javafx.scene.control.Button;

public class GameLogic {
    protected static char nextTurn = 'X';
    protected static char winner = '-';
    public static char playTurn(){
        char currentTurn = nextTurn;
        if(nextTurn == 'X'){
            nextTurn = 'O';
        }else{
            nextTurn = 'X';
            }
        return(currentTurn);
    }
    public static String turnLabel(List<Button> btnmap){
        
        winner = checkState(btnmap);
        if(winner == '-'){
            if(nextTurn == 'X'){
                return("X's Turn");
            }else if(nextTurn == 'O'){
                return("O's Turn");
            }
        }else{
            for(int i = 0; i < btnmap.size(); i++){
                btnmap.get(i).setDisable(true);
            }
            if(winner == 'X'){
                return("X Wins!");
            }else if(winner == 'O'){
                return("O Wins!");
            }else if(winner == 'N'){
                return("Tied Game");
            }
        }
        return(null);
    }
    private static char checkState(List<Button> btnmap){
        boolean filled = true;
        for(int i = 0; i < btnmap.size(); i++){ //check to see if tie
            if(btnmap.get(i).getText() == null){
                filled = false;
            }
        }
        for(int i = 0; i < 5; i++){ //check cols
            if((btnmap.get(i).getText() != null) && (btnmap.get(i).getText().equals(btnmap.get(i+5).getText())) && (btnmap.get(i).getText().equals(btnmap.get(i+10).getText())) && (btnmap.get(i).getText().equals(btnmap.get(i+15).getText())) && (btnmap.get(i).getText().equals(btnmap.get(i+20).getText()))){
                return(btnmap.get(i).getText().charAt(0));
            }
            
        }
        for(int i = 0; i <= 20; i+=5){ //check rows
            if((btnmap.get(i).getText() != null) && (btnmap.get(i).getText().equals(btnmap.get(i+1).getText())) && (btnmap.get(i).getText().equals(btnmap.get(i+2).getText())) && (btnmap.get(i).getText().equals(btnmap.get(i+3).getText())) && (btnmap.get(i).getText().equals(btnmap.get(i+4).getText()))){
                return(btnmap.get(i).getText().charAt(0));
            }
        }
        //check diag. (top -> bottom)
        if((btnmap.get(0).getText() != null) && (btnmap.get(0).getText().equals(btnmap.get(6).getText())) && (btnmap.get(0).getText().equals(btnmap.get(12).getText())) && (btnmap.get(0).getText().equals(btnmap.get(18).getText())) && (btnmap.get(0).getText().equals(btnmap.get(24).getText()))){
            return(btnmap.get(0).getText().charAt(0));
        }
        //check diag. (bottom -> top)
        if((btnmap.get(20).getText() != null) && (btnmap.get(20).getText().equals(btnmap.get(16).getText())) && (btnmap.get(20).getText().equals(btnmap.get(12).getText())) && (btnmap.get(20).getText().equals(btnmap.get(8).getText())) && (btnmap.get(20).getText().equals(btnmap.get(4).getText()))){
            return(btnmap.get(20).getText().charAt(0));
        }
        if(filled){
            return('N');
        }
        return('-');
    }
}
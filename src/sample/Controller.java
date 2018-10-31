package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    private TextField textField;

    private String number;
    private double firstNumber;
    private double secondNumber;
    private boolean isSecondNumber = false;

    public Controller(){
        number = "";  // fixme may cause bug with empty character
        firstNumber = 0;
        secondNumber = 0;
    }

    public void onClickListener(ActionEvent actionEvent){
        String text = ((Button)actionEvent.getSource()).getText();
        number = number + text;
        if (!isSecondNumber){
            firstNumber = Double.parseDouble(number);
            isSecondNumber = true;
        } else {
            secondNumber = Double.parseDouble(number);
            isSecondNumber = false;
        }
        number = number + text;
        textField.setText(number);
    }

    public void clearValue(){
        textField.setText("");
        number = "";
    }

    public void calculate(ActionEvent actionEvent){

    }
}

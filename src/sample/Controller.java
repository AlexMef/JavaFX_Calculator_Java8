package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    private TextField textField;

    private Calculator calculator = new Calculator();
    private String action;
    private double firstValue;
    private double secondValue;
    private double result;
    private double memory;
    private boolean isSecondNumber = false;

    public Controller(){
        firstValue = 0;
        secondValue = 0;
        memory = 0;
    }

    public void buttonClickListener(ActionEvent actionEvent){
        String text = ((Button)actionEvent.getSource()).getText();
        textField.appendText(text);

        if (!isSecondNumber){
            firstValue = Double.parseDouble(textField.getText());
            System.out.println("first number " + firstValue);
        } else {
            secondValue = Double.parseDouble(textField.getText());
            System.out.println("second number " + secondValue);
        }
    }

    public void clearValue(){
        textField.setText("");
        firstValue = 0;
        secondValue = 0;
        result = 0;
        isSecondNumber = false;
    }

    public void selectAction(ActionEvent actionEvent){
        String action = ((Button)actionEvent.getSource()).getText();
        this.action = action;
        System.out.println(action);
        textField.setText("");
        isSecondNumber = true;
    }

    public void calculate(){
        System.out.println("calculate(firstValue) : " + firstValue);
        System.out.println("calculate(secondValue) : " + secondValue);
        calculator.setFirstValue(firstValue);
        calculator.setSecondValue(secondValue);
        calculator.setAction(action);

        result = calculator.calculate();
        textField.setText(String.valueOf(result));
        firstValue = result;
        secondValue = 0;
        isSecondNumber = true;
    }

    public void changeSign(){
        if (!isSecondNumber){
            firstValue = (-1) * firstValue;
            textField.setText(String.valueOf(firstValue));
        } else {
            secondValue = (-1)* secondValue;
            textField.setText(String.valueOf(secondValue));
        }

        // FIXME: 03.11.2018 add change sign function for result
    }

    public void addToMemory(){
        if (result != 0) {
            memory = result;
        } else if (!isSecondNumber){
            memory = firstValue;
        } else {
            memory = secondValue;
        }
    }

    public void memoryRead(){
        if (!isSecondNumber){
            firstValue = memory;
            textField.setText(String.valueOf(firstValue));
        } else {
            secondValue = memory;
            textField.setText(String.valueOf(secondValue));
        }
    }
}

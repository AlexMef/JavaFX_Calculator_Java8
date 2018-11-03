package sample;

public class Calculator {
    private double firstValue;
    private double secondValue;
    private String action;

    public double getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(double firstValue) {
        this.firstValue = firstValue;
    }

    public double getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(double secondValue) {
        this.secondValue = secondValue;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public double calculate(){
        switch (action){
            case "+":
                return firstValue + secondValue;
            case "-" :
                return firstValue - secondValue;
            case "*":
                return firstValue * secondValue;
            case "/":
                return firstValue / secondValue;
            default:
                    return 0;
        }
    }
}

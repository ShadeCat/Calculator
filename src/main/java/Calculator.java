import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        twoNumberCalculator handler = new twoNumberCalculator();
        boolean run = true;
        while (run) {
            String result = handler.handle();
            System.out.println(result);
            run = handler.askContinue();
        }
    }
}

class twoNumberCalculator {
    private double first_number;
    private double second_number;
    private String operation;
    private Operation handler;

    public void takeConsoleInput(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение для рассчета:");
        first_number = in.nextDouble();
        operation = in.next();
        second_number = in.nextDouble();
    }

    public String handle(){
        String result;
        try {
            takeConsoleInput();
        } catch (Exception e){
            return "Некорректный ввод, введите пример из двух чисел в формате \"12 + 2\"";
        }
        boolean operationIsValid = validateOperation();
        if (!operationIsValid){
            result = "Неизвестное действие, допустимы +, -, =, /";
        } else {
            initHandler();
            double result_double = handler.execute(first_number, second_number);
            result = first_number + " " + operation + " " + second_number + " = " + result_double;
        }
        return result;
    }

    private void initHandler(){
        switch (this.operation) {
            case "+":
                handler = new Adder();
                break;
            case "-":
                handler = new Subtractor();
                break;
            case "*":
                handler = new Multiplier();
                break;
            case "/":
                handler = new Divisor();
        }
    }

    private boolean validateOperation(){
        boolean isValid = false;
        if(operation.equals("+") || operation.equals("-") || operation.equals("/") || operation.equals("*")){
            isValid = true;
        }
        return isValid;
    }

    public boolean askContinue(){
        boolean isContinue = false;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите 'y' для продолжения, либо любую строку для выхода");
        String userInput = in.next();
        if (userInput.equals("y")){
            isContinue = true;
        }
        return isContinue;
    }
}

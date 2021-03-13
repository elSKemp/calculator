package Calculator;

import java.util.Scanner;
import static Calculator.Convert.convert;
import static Calculator.Convert.convertToRoman;

public class Main {
    static char operator;
    static int firstNumber;
    static int secondNumber;
    static boolean firstRomanNumber = false, secondRomanNumber = false;

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input number1 math.operator number2: ");
        String input = scan.nextLine();

        convert(input);
        Integer result = calculate();

        if (result != null) {
            if (firstRomanNumber == true) {
                System.out.println("Answer: " + convertToRoman(result));
            } else {
                System.out.println("Answer: " + result);
            }
        }
    }

    public static Integer calculate() throws Exception {
        Integer result = null;

        if (firstRomanNumber == secondRomanNumber) {
            if (firstNumber < 0 || firstNumber > 10) {
                throw new Exception("Chek first number (must be : 0 - 10)");
            }

            if (secondNumber < 0 || secondNumber > 10) {
                throw new Exception("Chek second number (must be : 0 - 10)");
            }

            switch (operator) {
                case '+':
                    result = firstNumber + secondNumber;
                    break;

                case '-':
                    result = firstNumber - secondNumber;
                    break;

                case '*':
                    result = firstNumber * secondNumber;
                    break;

                case '/':
                    result = firstNumber / secondNumber;
                    break;

                // operator doesn't match any case constant (+, -, *, /)
                default:
                    throw new Exception("wrong math operator");
            }

            return result;
        } else {
            throw new Exception("Both inputs should be roman or decimal numbers");
        }
    }
}

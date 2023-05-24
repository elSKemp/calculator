package Calculator;
import java.util.InputMismatchException;
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
        System.out.print("Введите число1 (0-10) потом математический оператор (+-/*) потом число2 (0-10): ");
        String input = scan.nextLine();

        convert(input);
        Integer result = calculate();

        if (result != null ) {
            if (firstRomanNumber == true & secondRomanNumber == true) {
                System.out.println("Answer: " + convertToRoman(result));
            } else {
                System.out.println("Answer: " + result);
            }
        }
        if (result <= 0) {
            if (firstRomanNumber == true & secondRomanNumber == true) {
                throw new Exception("Отрицательный результат вычитания римских чисел либо результат 0");

            }
        }
    }

    public static Integer calculate() throws Exception {
        Integer result = null;

        if (firstRomanNumber == secondRomanNumber) {
            if (firstNumber < 0 || firstNumber > 10) {
                throw new Exception("Check first number (must be : 0 - 10)");
            }

            if (secondNumber < 0 || secondNumber > 10) {
                throw new Exception("Check second number (must be : 0 - 10)");
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
                    try {
                        result = firstNumber / secondNumber;
                    } catch (ArithmeticException | InputMismatchException e) {
                        System.out.println("Exception : " + e);
                        System.out.println("Only integer non-zero parameters allowed");

                        break;
                    }

                    break;

                // operator doesn't match any case constant (+, -, *, /)
                default:
                    throw new IllegalArgumentException("Не верный знак операции");
            }

            return result;
        } else {
            throw new Exception("Оба числа должны быть римскими (IiVvXxLlCcDdMm)");
        }
    }
}

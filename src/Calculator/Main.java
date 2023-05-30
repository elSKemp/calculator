package Calculator; // пакет Calculator , где лежат классы Convert, Main


import java.util.InputMismatchException; // импорт встроенной библиотеки , проверяет на существование запрашиваемого элемента
import java.util.Scanner;  // импорт встроенной библиотеки , сканер вводимых строк

import static Calculator.Convert.*;


public class Main { // объявляем класс Main - название токое же как файла Main.java
    static char operator; // инициализируем переменную operator типа char (символьный тип)
    static int firstNumber, secondNumber; // инициализируем переменные firstNumber , secondNumber типа int (целочисленный тип)
    static boolean firstRomanNumber = false, secondRomanNumber = false; // инициализируем переменные firstRomanNumber (первое римское число), secondRomanNumber (второе римское число) типа boolean (примнимают два значения - false (ложь) или true (истина) )

    public static void main(String args[]) throws Exception { // объявляем метод main (нижний регистр или camelcase, то есть с маленькой буквы, как и все методы в Java), который в свою очередь кидает Исключение Exception
        Scanner scan = new Scanner(System.in); // инициализируем объект scan типа Scanner, который будет считывать введенную в консоли строку
        System.out.print("Введите число1 (0-10) потом математический оператор (+-/*) потом число2 (0-10): "); // выводим в консоль строку Введите число.....
        String input = scan.nextLine();  // инициализируем переменную input, в которую попадает результат сканирования строки из консоли

        convert(input); // вызываем метод convert, который ничего не возращает а просто выполняет логику конвертации римских чисел в арабские
        Integer result = calculate(); // инициализируем переменную result, в которую попадает целочисленный результат выполнения метода calculate

        if (result != null ) { // обявляем ветвление , если переменная result не равна null (ничто), то
            if (firstRomanNumber == true & secondRomanNumber == true) { // если (первое римское число firstRomanNumber равно истина) и (второе римское число secondRomanNumber равно истина) то
                System.out.println("Ответ: " + convertNumToRoman(result)); // в консоль выводится Ответ: результат выполнения метода convertToRoman
            } else { // в другом случае (первое римское число firstRomanNumber равно ложь) и (второе римское число secondRomanNumber равно ложь), то есть это не римские числа)
                System.out.println("Ответ: " + result);  // в консоль выводится Ответ: целочисленная переменная result
            }
        }
        if (result <= 0) { // если переменная result меньеш или равна 0, то
            if (firstRomanNumber == true & secondRomanNumber == true) { // если (первое римское число firstRomanNumber равно истина) и (второе римское число secondRomanNumber равно истина) то
                throw new Exception("Результат 0 либо отрицательный результат вычитания римских чисел"); // кидаем исключение 'Отрицательный результат вычитания римских чисел либо результат 0'

            }
        }
    }

    public static Integer calculate() throws Exception { // объявляем метод calculate, он кидает исключение Exception (есть такой класс встроенный в java)
        Integer result = null; // инициализируем переменную result типа Integer (целочисленный тип обертка над int)

        if (firstRomanNumber == secondRomanNumber) {
            if ((firstNumber < 0 || firstNumber > 10) || (secondNumber < 0 || secondNumber > 10)) {
                throw new Exception("Первое или второе число должно быть от 0 до 10");
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
                        System.out.println("Ошибка - деление на 0");

                        break;
                    }

                    break;

                // operator doesn't match any case constant (+, -, *, /)
                default:
                    throw new IllegalArgumentException("Неверный знак операции, должно быть  (+, -, *, /)");
            }

            return result;
        } else {
            throw new Exception("Оба числа должны быть римскими (IiVvXxLlCcDdMm) от 0 до 10");
        }
    }
}

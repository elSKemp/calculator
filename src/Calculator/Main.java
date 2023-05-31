package Calculator; // пакет Calculator , где лежат классы Convert, Main


import java.util.InputMismatchException; // импорт встроенной библиотеки , проверяет на существование запрашиваемого элемента
import java.util.Scanner;  // импорт встроенной библиотеки , сканер вводимых строк

import static Calculator.Convert.*; // импорт всех методов (* - значит все) из класса Convert


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
        Integer result = null; // инициализируем переменную result типа Integer (целочисленный тип обертка над int), присваиваем ей значение null (ничто) - такие правила инициализации объектов в java

        if (firstRomanNumber == secondRomanNumber) { // условие - если firstRomanNumber (первое римское число) лигически равно (==) secondRomanNumber (второму римскому числу)
            if ((firstNumber < 0 || firstNumber > 10) || (secondNumber < 0 || secondNumber > 10)) { // здесь логически выставляются условия ограничивающие первое и второе число ( < 0, > 10 )
                throw new Exception("Первое или второе число должно быть от 0 до 10");  // кидаем или выбрасываем исключение через ключевое слово new (создает новый объект)
            }
            switch (operator) {  // объявляем оператор switch case (логический оператор выбора, на основании входящих данных operator)
                case '+': // случай когда operator + (сложение)
                    result = firstNumber + secondNumber; // в переменную result записывается результат сложения firstNumber и secondNumber
                    break;

                case '-': // аналогично вычитание
                    result = firstNumber - secondNumber;
                    break;

                case '*': // аналогично умножение
                    result = firstNumber * secondNumber;
                    break;

                case '/': // аналогично деление
                    try { // здесь используется конструкция  try catch - логический блок, где выполняется операция деления, пока не кинется исключение ArithmeticException (арифметическое исключение - например джеление на 0) или  InputMismatchException (исключение когда введен неправильные данные)
                        result = firstNumber / secondNumber; // в переменную result записывается результат деления firstNumber на secondNumber
                    } catch (ArithmeticException | InputMismatchException e) { // блок где обрабатыываются исключения ArithmeticException и InputMismatchException, объект исключения записывается в переменную e
                        System.out.println("Exception : " + e); // выводим в консоль строку с исключением
                        System.out.println("Ошибка - деление на 0"); // выводим в консоль строку с текстом арифметического исключения
                        break; // ключевое слово break - значит остановка выполнения программы, если кинулось исключение в результате операции деления
                    }
                    break; // ключевое слово break относится к общему случаю case '/'
                default: // ключевое слово default означает, что по-умолчанию в конструкция switch case, кидается исключение в результате неверно введенного в консоли математического оператора, то есть вместо  (+, -, *, /) ввели например = или любой другой символ
                    throw new IllegalArgumentException("Неверный знак операции, должно быть  (+, -, *, /)"); // само исключение IllegalArgumentException и что должно выводится в консоль, если оно произошло
            }

            return result; // ключевое слово return относится к методу calculate, означает возврат значения result, в которую записывается результат вычислений метода
        } else { // часть конструкции if else, означает что будет если не выполняются условия в 41 строке (смотрим вертикально от if на 72 строке стоит фигурная скобка)
            throw new Exception("Оба числа должны быть римскими (IiVvXxLlCcDdMm) от 0 до 10"); // кидаем исключение и текст исключения
        }
    }
}

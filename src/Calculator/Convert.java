package Calculator;

import java.util.Arrays; // импорт втроенной в java (jdk) библиотеки для работы с массивами Arrays
import java.util.InputMismatchException;// импорт втроенной в java (jdk) библиотеки для работы с исключением InputMismatchException (несоответствие введеных данных запрашиваемым)

import static Calculator.Main.firstNumber; // импорт перемнной firstNumber из класса Main
import static Calculator.Main.secondNumber; // импорт перемнной secondNumber из класса Main
import static Calculator.Main.firstRomanNumber; // импорт перемнной firstRomanNumber из класса Main
import static Calculator.Main.secondRomanNumber; // импорт перемнной secondRomanNumber из класса Main
import static Calculator.Main.operator; // импорт перемнной operator из класса Main

public class Convert { // в этом методе , обрабатывается логика конвертации и парсинга (обработки) введенных данных из консоли
    public static void convert(String input) { // объявляем метод convert (нижний регистр как в дргуих методах, то есть с маленькой буквы), который ничего не возвращает ( ключевое слово void), на вход ему подается переменнвя input типа String

        char[] chars = input.toCharArray();  // инициализируем массив символов chars, в него записываем результат выполнения метода toCharArray(встроен в jdk, находится в Arrays) над строковой переменной input, то есть этот метод преобразовывает в массив символов введенную в консоли строку

        int charsLength = chars.length; // инициализируем переменную charsLength типа int, в которую складывается длинна строки chars (length - это метод вычисляет длинну строки он встроен в jdk)

        String op = "+-*/"; // инициализируем строку op, в нее входят операторы
        String des = "IVX";  // инициализируем строку des, в нее входят римские числа до 10

        for (int i = 0; i < charsLength; i++) { // объявляем цикл for, он итерирует (пробегает циклически) переменную i столько раз сколько равно длинне строки charsLength со счетчиком i++ (означает что счетчик с каждой итерацией будет увеличиваться на 1)

            if (op.indexOf(chars[i]) >= 0) {  // условие логического ветвления if (если)
                operator = chars[i];  // присваиваем переменной  operator итый индекс массива (или значение итого индекса массива)

                char[] chr_firstNumber = Arrays.copyOfRange(chars, 0, i);
                String str_firstNumber = String.valueOf(chr_firstNumber);
                str_firstNumber = str_firstNumber.trim();

                char[] chr_secondNumber = Arrays.copyOfRange(chars, i + 1, charsLength);
                String str_secondNumber = String.valueOf(chr_secondNumber);
                str_secondNumber = str_secondNumber.trim();

                if (des.indexOf(str_firstNumber.charAt(0)) >= 0) {  // условие логического ветвления if (если)
                    firstNumber = romanToNumber(str_firstNumber);  // здесь уже в переменную firstNumber записывается результат выполнения метода romanToNumber (метод конвертации римских чиселв арабские)
                    firstRomanNumber = true;  // переменной firstRomanNumber присваивается значение true (истина)
                }
                else { // условие логического ветвления else (или)
                    try { // открывается блок try
                        firstNumber = Integer.parseInt(str_firstNumber); // в переменную firstNumber присваиваем результат выполнения метода parseInt (встроенный в jdk метод, точнее это метода класса обертки Integer), на вход методу подается переменная str_firstNumber типа String
                    } // закрываем  блок try
                    catch (NumberFormatException e) {  // ловим исключение
                        firstNumber = -1; //  в переменную firstNumber присваиваем -1
                    }
                }

                if (des.indexOf(str_secondNumber.charAt(0)) >= 0) {  // условие логического ветвления if (если)
                    secondNumber = romanToNumber(str_secondNumber);  // здесь уже в переменную secondNumber записывается результат выполнения метода romanToNumber (метод конвертации римских чиселв арабские)
                    secondRomanNumber = true; // переменной secondRomanNumber присваивается значение true (истина)
                }
                else { // условие логического ветвления else (или)
                    try { // открывается блок try
                        secondNumber = Integer.parseInt(str_secondNumber); // в переменную secondNumber присваиваем результат выполнения метода parseInt (встроенный в jdk метод, точнее это метода класса обертки Integer), на вход методу подается переменная str_secondNumber типа String
                    }
                    catch (NumberFormatException e) { // ловим исключение
                        secondNumber = -1;  //  в переменную secondNumber присваиваем -1
                    }
                }
            }
        }

    }
    static String convertNumToRoman(int numArabian) { // объявляем метод convertNumToRoman он используется в классе Main, на вход ему подается переменная типа int
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };  // инициализируем массив стрингов roman
        final String s = roman[numArabian];  // инициализируем финализированную переменную s типа String
        return s;
    }
    private static int romanToNumber (String roman) { // объявляем метод romanToNumber, в нем переводятся римские в арабские
        try { // открывается блок try
            if (roman.equals("I")) { // условие логического ветвления if (если), римское число = I, возвращаемое значение =1
                return 1;
            } else if (roman.equals("II")) { // условие логического ветвления if (если), римское число = II, возвращаемое значение =2 и тд
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) { // ловим исключение
            throw new InputMismatchException("Неверный формат данных"); // кидаем исключение с текстом "Неверный формат данных"
        }
        return -1;
    }


}

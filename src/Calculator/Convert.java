package Calculator;

import java.util.Arrays;
import java.util.InputMismatchException;

import static Calculator.Main.firstNumber;
import static Calculator.Main.secondNumber;
import static Calculator.Main.firstRomanNumber;
import static Calculator.Main.secondRomanNumber;
import static Calculator.Main.operator;

public class Convert {
    public static void convert(String input) {

        char[] chars = input.toCharArray();

        int charsLength = chars.length;

        String op = "+-*/";
        String des = "IiVvXxLlCcDdMm";

        for (int i = 0; i < charsLength; i++) {

            if (op.indexOf(chars[i]) >= 0) {
                operator = chars[i];

                char[] chr_firstNumber = Arrays.copyOfRange(chars, 0, i);
                String str_firstNumber = String.valueOf(chr_firstNumber);
                str_firstNumber = str_firstNumber.trim();

                char[] chr_secondNumber = Arrays.copyOfRange(chars, i + 1, charsLength);
                String str_secondNumber = String.valueOf(chr_secondNumber);
                str_secondNumber = str_secondNumber.trim();

                if (des.indexOf(str_firstNumber.charAt(0)) >= 0) {
                    firstNumber = romanToNumber(str_firstNumber);
                    firstRomanNumber = true;
                }
                else {
                    try {
                        firstNumber = Integer.parseInt(str_firstNumber);
                    }
                    catch (NumberFormatException e) {
                        firstNumber = -1;
                    }
                }

                if (des.indexOf(str_secondNumber.charAt(0)) >= 0) {
                    secondNumber = romanToNumber(str_secondNumber);
                    secondRomanNumber = true;
                }
                else {
                    try {
                        secondNumber = Integer.parseInt(str_secondNumber);
                    }
                    catch (NumberFormatException e) {
                        secondNumber = -1;
                    }
                }
            }
        }

    }
    static String convertNumToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }
    private static int romanToNumber (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
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
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }


}

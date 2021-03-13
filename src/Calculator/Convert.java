package Calculator;

import java.util.Arrays;

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
                    firstNumber = convertToDecimal(str_firstNumber);
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
                    secondNumber = convertToDecimal(str_secondNumber);
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

    public static int convertToDecimal(String romanNumeral) {
        int decimalNum = 0;

        romanNumeral = romanNumeral.toUpperCase();

        int l = romanNumeral.length();
        int num = 0;
        int previousnum = 0;
        for (int i = l - 1; i >= 0; i--) {
            char x = romanNumeral.charAt(i);
            x = Character.toUpperCase(x);
            switch (x) {
                case 'I':
                    previousnum = num;
                    num = 1;
                    break;
                case 'V':
                    previousnum = num;
                    num = 5;
                    break;
                case 'X':
                    previousnum = num;
                    num = 10;
                    break;
            }
            if (num < previousnum) {
                decimalNum = decimalNum - num;
            }
            else
                decimalNum = decimalNum + num;
        }

        return decimalNum;
    }

    public static String convertToRoman(int num) {

        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romanLiterals = {
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }

        return roman.toString();
    }
}

package calculator_Kata;

import java.util.Arrays;
import java.util.List;

public class Calculations {
    private int x1, x2;
    private String operator;


    private int calcExp(int n1, String op, int n2) {
        int res;
        switch (op) {
            case "+":
                res = n1 + n2;
                break;
            case "-":
                res = n1 - n2;
                break;
            case "*":
                res = n1 * n2;
                break;
            case "/":
                res = n1 / n2;
                break;
            default:
                throw new AssertionError();
        }
        return res;
    }


    public String result(String exp) throws Exceptions {
        boolean isRomanExp;
        Arabic arabic = new Arabic();


        List<String> expItems = Arrays.asList(exp.split(" "));


        if (expItems.size() != 3) {
            throw new Exceptions("Ошибка. неверный вид выражения");
        }


        if (arabic.checkOperator(expItems.get(1))) {
            operator = expItems.get(1);
        } else {
            throw new Exceptions("Ошибка. Неверный оператор");
        }


        if (arabic.isNumeric(expItems.get(0)) && arabic.isNumeric(expItems.get(2))) {
            x1 = Integer.parseInt(expItems.get(0));
            x2 = Integer.parseInt(expItems.get(2));
            isRomanExp = false;
        } else if (arabic.isRoman(expItems.get(0)) && arabic.isRoman(expItems.get(2))) {
            x1 = arabic.romeToArabConvert(expItems.get(0));
            x2 = arabic.romeToArabConvert(expItems.get(2));
            isRomanExp = true;
        } else {
            throw new Exceptions("Ошибка. Оба числа должны быть арабскими или римскими одновременно ");
        }


        if (!(x1 >= 1 && x1 <= 10) || !(x2 >= 1 && x2 <= 10)) {
            throw new Exceptions("Ошмбк.Числа должны быть от 1 до 10 или от I до X включительно");
        }


        int res = calcExp(x1, operator, x2);


        if (isRomanExp) {
            if (res > 0) {
                return arabic.arabToRomeConvert(Math.abs(res));
            } else throw new Exceptions("Ошибка. Для Римских чисел результат должен быть больше 1");
        }


        return String.valueOf(res);
    }

}

package calculator_Kata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        System.out.println("Введите выражение в формате: \"Число1 Операция Число2\"");
        System.out.print("Для выхода введите \"закрыть\". \n");
        while (true) {

            try {
                System.out.print("Введите выражение: ");
                BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
                String input = bReader.readLine();
                if (input.equals("закрыть")){
                    System.out.print("До новых встреч!");
                    break;
                }
                String result = calc(input);
                System.out.println("Ответ: " + result);
            } catch (Exceptions | IOException e) {
                System.out.print("До новых встреч!");
                break;

            }
        }

    }
    public static String calc(String input) throws Exceptions {

        Calculations calculations = new Calculations();

        String result = calculations.result(input);
        return result;

    }

}

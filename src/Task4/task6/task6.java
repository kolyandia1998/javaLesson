package Task4.task6;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class task6 {
    public static void BoollLogic(Boolean a, Boolean b) {
        if (a && !b) {
            System.out.println("Это число в обычной нотации");
        } else if (!a && b) {

            System.out.println("Это число в научной нотации");
        } else System.out.println("Это не число");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        Boolean a = input.matches("-?\\d+(\\.\\d+)?");
        Boolean b = input.matches("^(-?\\d+)\\.?\\d+(e-|e\\+|\\d+)\\d+$");
        BoollLogic(a, b);


    }

}

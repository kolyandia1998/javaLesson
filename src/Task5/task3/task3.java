package Task5.task3;

import java.io.BufferedReader;
import java.io.InputStreamReader;


import static Task5.task2.Round.positiveValid;
import static Task5.task3.Triangle.printMessage;
import static Task5.task3.Triangle.tryParseDouble;

public class task3 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Double A = null, B = null, C = null;

        while (A == null || B == null || C == null) {
            if (A == null || !positiveValid(A)) {
                printMessage("Введите А (A должно быть положительным)");
                A = tryParseDouble(bufferedReader.readLine());
            } else if (B == null || !positiveValid(B)) {
                printMessage("Введите B (В должно быть положительным)");
                B = tryParseDouble(bufferedReader.readLine());
            } else if (C == null || !positiveValid(C)) {
                printMessage("Введите C (С должно быть положительным)");
                C = tryParseDouble(bufferedReader.readLine());

            }

        }
        bufferedReader.close();
        Triangle triangle = new Triangle(A, B, C);

        System.out.println("Периметр равен:" + triangle.getPerimeter());
        System.out.println("Площадь равна:" + triangle.getSquare());
    }
}

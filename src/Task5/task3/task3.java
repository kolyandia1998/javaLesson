package Task5.task3;

import java.io.BufferedReader;
import java.io.InputStreamReader;


import static Task5.task3.Triangle.printMessage;
import static Task5.task3.Triangle.tryParseDouble;

public class task3 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Double A = null;
        Double B = null;
        Double C = null;

        while (A == null || B == null || C == null) {
            if (A == null) {
                printMessage("Введите А");
                A = tryParseDouble(bufferedReader.readLine());
            } else if (B == null) {
                printMessage("Введите B");
                B = tryParseDouble(bufferedReader.readLine());
            } else {
                printMessage("Введите C");
                C = tryParseDouble(bufferedReader.readLine());
            }

        }
        bufferedReader.close();
        Triangle triangle = new Triangle(A, B, C);

        System.out.println("Периметр равен:" + triangle.getPerimeter());
        System.out.println("Площадь равна:" + triangle.getSquare());
    }
}

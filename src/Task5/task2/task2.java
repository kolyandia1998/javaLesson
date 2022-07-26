package Task5.task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static Task5.task3.Triangle.printMessage;
import static Task5.task3.Triangle.tryParseDouble;

public class task2 {
    public static void main(String[] args) throws Exception {
        Double X = null;
        Double Y = null;
        Double radius = null;
        Double Z = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (X == null || Y == null || radius == null) {
            if (X == null) {
                printMessage("Введите координату центра по оси X");
                X = tryParseDouble(bufferedReader.readLine());
            } else if (Y == null) {
                printMessage("Введите координату центра по оси Y");
                Y = tryParseDouble(bufferedReader.readLine());
            } else {
                printMessage("Введите радиус");
                radius = tryParseDouble(bufferedReader.readLine());
            }
        }
            Round circle = new Round(X, Y, radius);


            System.out.println("Площадь равна:" + circle.getCircleS());
            circle.getCircleS();
            System.out.println("Длина равна:" + circle.getCircleLong());

        }
    }


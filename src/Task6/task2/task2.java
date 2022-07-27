package Task6.task2;

import Task5.task2.Round;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static Task5.task2.Round.positiveValid;
import static Task5.task3.Triangle.printMessage;
import static Task5.task3.Triangle.tryParseDouble;

public class task2 {


    public static void main(String[] args) throws IOException {


        Double X = null, Y = null, radius = null, innerRadius = null;


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (X == null || Y == null || radius == null || innerRadius == null) {
            if (X == null) {
                printMessage("Введите координату центра по оси X");
                X = tryParseDouble(bufferedReader.readLine());
            } else if (Y == null) {
                printMessage("Введите координату центра по оси Y");
                Y = tryParseDouble(bufferedReader.readLine());
            } else if (radius == null) {
                printMessage("Введите внешний радиус");
                radius = tryParseDouble(bufferedReader.readLine());
            } else if (innerRadius == null) {
                printMessage("Введите внутренний радиус");
                innerRadius = tryParseDouble(bufferedReader.readLine());
            }
        }
        Ring ring = null;
        try {
            ring = new Ring(X, Y, radius, innerRadius);
            System.out.println("Площадь равна:" + ring.ringSquare());
            System.out.println("Длина внутренняя:" + ring.getCircleLong());
            System.out.println("Длинна внешняя: " + ring.getCircleLong());
            System.out.println(ring.getCircleS());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}
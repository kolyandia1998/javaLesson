package Task5.task3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Triangle {
    private double A;
    private double B;
    private double C;


    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static Double tryParseDouble(String input) {
        try {

            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return null;
        }

    }


    public Triangle(double A, double B, double C) throws Exception {
        if (A <= 0 || B <= 0 || C <= 0 || (A == B && B == C)) {
            throw new Exception("Сторона треугольника должны быть больше 0 и не могут быть равны");
        }

        this.A = A;
        this.B = B;
        this.C = C;

    }


    public double getPerimeter() {
        return A + B + C;
    }

    public double getSquare() {
        double perimeter = getPerimeter();
        return Math.sqrt(perimeter * (perimeter - A) * (perimeter - B) * (perimeter - C));
    }


}

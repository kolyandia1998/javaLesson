package Task5.task3;

import Task5.task3.Exeption.TriangleExeption;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Triangle {
    private double A, B, C;


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


    public Triangle(double A, double B, double C) throws  Exception {
        if (A <= 0 || B <= 0 || C <= 0) {
            throw new TriangleExeption("Стороны треугольника должны быть положительными");
        }

        if (A + B > C && A + C > B && B + C > A) {
            this.A = A;
            this.B = B;
            this.C = C;
        } else
            throw new TriangleExeption("Треугольник существует тогда," + "\n" + " когда сумма любых двух его сторон больше третьей стороны." + "\n" +
                    " В данном случае, условие не выполняется, следовательно, треугольник не существует.");
    }


    public double getPerimeter() {
        return A + B + C;
    }

    public double getSquare() {
        double perimeter = getPerimeter();
        return Math.sqrt(perimeter * (perimeter - A) * (perimeter - B) * (perimeter - C));
    }


}

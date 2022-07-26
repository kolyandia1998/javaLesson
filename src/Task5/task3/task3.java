package Task5.task3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class task3 {
    public static void main(String[] args) throws Exception {
        Triangle triangle = new Triangle();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите стороны A,B,C");
        triangle.setA(Integer.parseInt(bufferedReader.readLine()));
        triangle.setB(Integer.parseInt(bufferedReader.readLine()));
        triangle.setC(Integer.parseInt(bufferedReader.readLine()));
        System.out.println("Периметр равен:" + triangle.getPerimeter());
        System.out.println("Площадь равна:" + triangle.getSquare());
    }
}

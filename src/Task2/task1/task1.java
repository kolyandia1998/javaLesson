package Task2.task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class task1 {

    private int a;
    private int b;

    public void setA(Integer a) {
        this.a = PositiveValidate(a);
    }

    public Integer getA() {
        return a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = PositiveValidate(b);
    }


    public static Integer tryParse(String s) throws Exception {
        try {
            return Integer.parseInt(s);

        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static Integer PositiveValidate(Integer a) {

        if (a == null || a <= 0) {
            throw new IllegalArgumentException("value can't be negative!");
        } else
            return a;
    }

    public float getSquare() {
        return (float) (a * b) / 2;

    }


    public static void main(String[] args) throws Exception {

        task1 triangle = new task1();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer a = null;
        System.out.println("enter a");
        while (a == null) {
            a = tryParse(bufferedReader.readLine());
        }
        triangle.setA(a);


        Integer b = null;
        System.out.println("enter b");
        while (b == null) {
            b = tryParse(bufferedReader.readLine());
        }
        triangle.setB(b);


        System.out.println("Square value is:" + triangle.getSquare());


    }


}
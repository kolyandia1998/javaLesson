package Task2.task2and3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class task2and3 {
    private Integer a;

    public void setA(Integer a) {
        this.a = PositiveValidate(a);
    }

    public Integer getA() {
        return a;
    }

    public static Integer PositiveValidate(Integer a) {

        if (a == null || a <= 0) {
            throw new IllegalArgumentException("value can't be negative!");
        } else
            return a;
    }


    public static Integer tryPars(String in) {
        try {
            return Integer.parseInt(in);
        } catch (NumberFormatException e) {
            return null;
        }

    }


    public static void Trees(int line, Boolean middle, Boolean defaultMiddle, int fixMid) {

        int center = 0;
        int starstep = 1;
        if (middle) {
            if (defaultMiddle) {
                center = line;
            } else {
                center = fixMid;
            }
            starstep = 2;
        }

        String star = "*";
        String spaсe = "";

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < center; j++) {
                spaсe += " ";

            }
            System.out.println(spaсe + star);
            for (int j = 0; j < starstep; j++) {
                star += "*";
            }
            spaсe = "";
            center--;

        }

    }


    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer N = null;
        System.out.println("enter number of lines");
        while (N == null) {
            N = tryPars(bufferedReader.readLine());
        }

        task2and3 keyReader = new task2and3();
        keyReader.setA(N);

        Trees(keyReader.getA(), true, false, keyReader.getA());


    }

}

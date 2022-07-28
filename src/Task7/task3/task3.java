package Task7.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;

public class task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Введите первый член прогрессии и шаг прогрессии");
            ArithmeticalProgression arithmeticalProgression = new ArithmeticalProgression(Double.parseDouble(bufferedReader.readLine()), Double.parseDouble(bufferedReader.readLine()));
            ArithmeticalProgression.PrintSeries(arithmeticalProgression);
            System.out.println("Введите индекса элемента прогрессии");
            System.out.println(arithmeticalProgression.thisElement(Integer.parseInt(bufferedReader.readLine())));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        double[] array = new double[10];
        array[0] = 1.0;
        array[1] = 2.0;
        array[2] = 3.0;
        array[3] = 4.0;
        array[4] = 5.0;
        array[5] = 6.0;
        array[6] = 7.0;
        array[7] = 8.0;
        array[8] = 9.0;
        array[9] = 10.0;

        List list = new List(array);
        try {
            System.out.println("Введите индекса элемента ");
            System.out.println(list.thisElement(Integer.parseInt(bufferedReader.readLine())));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}

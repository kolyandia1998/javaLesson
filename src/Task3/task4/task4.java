package Task3.task4;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import static Task2.task2and3.task2and3.*;
public class task4 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите x размерность");
        Integer x = tryPars(bufferedReader.readLine());
        while (x == null || x < 0) {
            x = tryPars(bufferedReader.readLine());

        }

        System.out.println("Введите y размерность");
        Integer y = tryPars(bufferedReader.readLine());
        while (y == null || y < 0) {
            y = tryPars(bufferedReader.readLine());

        }
        int[][] input = new int[x][y];
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                input[i][j] = (int) (Math.random() * 12 - 5);
                System.out.println(input[i][j]);
            }
        }


        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if ((i + j) % 2 == 0) {
                    sum += input[i][j];
                }
            }
        }
        System.out.println("Сумма четных элементов = " + sum);
    }
}

package Task3.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static Task2.task2and3.task2and3.*;

public class task2 {

    public static void main(String[] args) throws IOException {
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
        System.out.println("Введите y размерность");
        Integer z = tryPars(bufferedReader.readLine());
        while (z == null || z < 0) {
            z = tryPars(bufferedReader.readLine());

        }


        int[][][] input = new int[x][y][z];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                for (int q = 0; q < input[0][0].length; q++) {
                    input[i][j][q] = (int) (Math.random() * 12 - 5);
                    System.out.println(input[i][j][q]);
                }
            }

        }


        System.out.println("Массив после замены");
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0][0].length; j++) {
                for (int q = 0; q < input[0][0].length; q++) {
                    if (input[i][j][q] > 0) {
                        input[i][j][q] = 0;
                    }

                    System.out.println(input[i][j][q]);
                }
            }

        }


    }


}


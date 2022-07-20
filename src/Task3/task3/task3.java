package Task3.task3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static Task2.task2and3.task2and3.*;

public class task3 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите размерность массива");
        Integer x = tryPars(bufferedReader.readLine());

        while (x == null || x < 0) {
            x = tryPars(bufferedReader.readLine());
        }


        int[] input = new int[x];
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            input[i] = (int) (Math.random() * 12 - 5);
            if (input[i] >= 0) {
                sum += input[i];
            }
            System.out.println(input[i]);
        }

        System.out.println("Сумма неотрицательных элементов");
        System.out.println(sum);
    }
}

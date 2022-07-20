package Task3.task1;

import com.sun.jdi.Value;

public class task1 {
    public static void main(String[] args) {

        int[] input = new int[10];

        System.out.println("Изначальный массив");
        for (int i = 0; i < input.length; i++) {
            input[i] = (int) (Math.random() * 12);
            System.out.println(input[i]);
        }

        for (int out = input.length - 1; out >= 1; out--) {
            for (int in = 0; in < out; in++) {
                if (input[in] < input[in + 1]) {
                    int swap = input[in];
                    input[in] = input[in + 1];
                    input[in + 1] = swap;
                }
            }

        }

         System.out.println("Отсортированный массив");

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }


}

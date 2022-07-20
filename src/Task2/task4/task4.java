package Task2.task4;

import java.io.BufferedReader;
import java.io.InputStreamReader;


import static Task2.task2and3.task2and3.*;

public class task4 {

    public static void PrintTree(Integer N) {

        int i = 0;
        int n = 2;
        while (i <= N) {


            Trees(i, true, false, N);
            i++;
        }

    }


    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Integer N = tryPars(bufferedReader.readLine());
        while (N == null || N <= 0) {
            N = tryPars(bufferedReader.readLine());
        }

        PrintTree(N);
    }


}


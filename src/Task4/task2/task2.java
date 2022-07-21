package Task4.task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class task2 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите первую строку");
        String first = bufferedReader.readLine();
        System.out.println("Введите вторую строку");
        String second = bufferedReader.readLine();

        StringBuilder sb = new StringBuilder();
        second.chars().distinct().forEach(c -> sb.append((char) c));
        second = sb.toString();
        char[] characters = second.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            System.out.println(characters[i]);
        }

        for (int i = 0; i < characters.length; i++) {
            first = first.replace(String.valueOf(characters[i]), String.valueOf(characters[i]) + String.valueOf(characters[i]));
        }

        System.out.println(second);

        System.out.println("Результат:" + first);
    }
}

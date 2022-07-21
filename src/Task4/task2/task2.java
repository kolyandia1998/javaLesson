package Task4.task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class task2 {

    public static String removeCrown(String str) {
        StringBuilder sb = new StringBuilder();
        str.chars().distinct().forEach(c -> sb.append((char) c));
        return sb.toString();

    }

    public static String charReplace(char[] a, String str) {
        for (int i = 0; i < a.length; i++) {
            str = str.replace(String.valueOf(a[i]), String.valueOf(a[i]) + String.valueOf(a[i]));
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите первую строку");
        String first = bufferedReader.readLine();
        System.out.println("Введите вторую строку");
        String second = removeCrown(bufferedReader.readLine());
        char[] characters = second.toCharArray();
        System.out.println("Результат:" + charReplace(characters, first));
    }
}

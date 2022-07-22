package Task4.task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task1 {
    static private final char[] punctuationChar = new char[]{',', ':', '-', ';', '!', '?', '.'};

    public static String[] punctuationDelete(String[] word) {
        for (int i = 0; i < word.length; i++) {
            for (char a : punctuationChar) {
                word[i] = word[i].replace(String.valueOf(a), "");
            }
        }
        return word;

    }

    public static int symbolCount(String[] a) {
        int symbol = 0;
        for (int i = 0; i < a.length; i++) {

            symbol += a[i].length();
        }
        return symbol;
    }

    public static int wordCount(String[] str) {
        int wordCount = 0;
        for (int i = 0; i < str.length; i++) {
            Pattern pattern = Pattern.compile("[a-zA-Zа-яА-Я]", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(str[i]);
            if (matcher.find()) {
                wordCount++;
            }

        }
        return wordCount;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите предложение:");
        String[] word = punctuationDelete(bufferedReader.readLine().split(" "));
        System.out.println("Срежнее количество букв в слове = " + (double) symbolCount(word) / wordCount(word));

    }

}




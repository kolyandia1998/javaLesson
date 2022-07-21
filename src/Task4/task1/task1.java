package Task4.task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task1 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = bufferedReader.readLine();
        char[] punctuationChar = new char[]{',', ':', '-', ';', '!', '?', '.'};
        String[] word = inputString.split(" ");
        for (String s : word) {
            System.out.println(s);
        }
        for (int i = 0; i < word.length; i++) {
            for (char a : punctuationChar) {
                word[i] = word[i].replace(String.valueOf(a), "");
            }
        }
        int letterCount = 0;

        for (int i = 0; i < word.length; i++) {

            letterCount += word[i].length();
        }


        int wordCount = 0;
        for (int i = 0; i < word.length; i++) {
            Pattern pattern = Pattern.compile("[a-zA-Zа-яА-Я]", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(word[i]);
            if (matcher.find()) {
                wordCount++;
            }

        }

        System.out.println("Срежнее количество букв в слове = " + (double) letterCount / wordCount);


    }

}




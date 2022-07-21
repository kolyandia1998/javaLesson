package Task4.task7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task7 {



    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        int count = 0;
        Pattern pattern = Pattern.compile("(([0,1][0-9])|(2[0-3])):[0-5][0-9]");
        Matcher matcher = pattern.matcher(input);


        while (matcher.find()) {
            count++;
        }
        System.out.println("Время в тексте встречается " + count + " раза");

    }
}

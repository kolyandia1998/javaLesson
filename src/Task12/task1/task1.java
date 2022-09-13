package Task12.task1;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task1 {


    public static void main(String[] args) throws IOException {

        File file = new File("C:\\1.txt");
        Scanner scanner = new Scanner( file);
        String fileData = "";

        int a;
        while (scanner.hasNextLine()) {
            fileData += scanner.nextLine() + "\n";
        }
      String regex ="\\d+";


        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fileData);

        while (matcher.find()){
          fileData = matcher.replaceAll(matchResult -> String.valueOf(Integer.parseInt(matcher.group())*Integer.parseInt(matcher.group())));
        }

        System.out.println(fileData);



    }
}

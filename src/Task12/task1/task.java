package Task12.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("C:\\1.txt"));
        String regex = "\\d+";
        String inputData = "";

        while (scanner.hasNext()) {
            inputData += scanner.next() + "\n";
        }
        scanner.close();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputData);

        while (matcher.find()) {
            inputData = matcher.replaceAll(MatchResult -> String.valueOf(Integer.parseInt(matcher.group()) * Integer.parseInt(matcher.group())));
        }

        File file = new File("C:\\1.txt");
        file.delete();
        file.createNewFile();

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(inputData);
        fileWriter.flush();
        fileWriter.close();
    }
}
package Task1.task1;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task1 {
    public static boolean ValidatePath(String path) throws Exception {
        File file = new File(path);
        return file.exists();

    }

    public static boolean ValidateInteger(String s) throws Exception {
        return s.matches("[+]?\\d+");
    }

    public static ArrayList<String> mainWords() throws Exception {
        ArrayList<String> words = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество слов:");

        String integer = bufferedReader.readLine();
        while (!ValidateInteger(integer)) {
            integer = bufferedReader.readLine();
        }
        int i = Integer.parseInt(integer);
        System.out.println("Введите слова:");
        for (int a = 0; a < i; a++) {
            words.add(bufferedReader.readLine());
        }
        return words;
    }


    public static void main(String[] args) throws Exception {

        class KeyWord {

            int counter;
            String word;

            public KeyWord(int counter, String word) {
                this.counter = counter;
                this.word = word;
            }


        }


        ArrayList<String> words = mainWords();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь:");
        String path = bufferedReader.readLine();

        while (!ValidatePath(path)) {
            path = bufferedReader.readLine();
        }

        FileInputStream file = new FileInputStream(path);
        byte[] inputByte = new byte[file.available()];
        int i;
        while ((i = file.read()) != -1) {
            file.read(inputByte);
        }
        String inputData = new String(inputByte);

        Pattern pattern = Pattern.compile(
                "(/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/)|(//.*)");
        Matcher matcher = pattern.matcher(inputData);
        inputData = matcher.replaceAll("");

        ArrayList<KeyWord> keyWords = new ArrayList<>();


        for (int q = 0; q < words.size(); q++) {
            Pattern pattern1 = Pattern.compile(words.get(q));
            Matcher matcher1 = pattern1.matcher(inputData);

            int count = 0;
            while (matcher1.find()) {
                count++;
            }
            keyWords.add(new KeyWord(count, words.get(q)));
        }


        Collections.sort(keyWords, new Comparator<KeyWord>() {
            @Override
            public int compare(KeyWord o1, KeyWord o2) {
                return Integer.compare(o2.counter, o1.counter);
            }
        });

        for (int q = 0; q < keyWords.size(); q++) {
            System.out.println(keyWords.get(q).word + " - " + keyWords.get(q).counter);
        }

        ArrayList<KeyWord> Top = new ArrayList<>();

        for (int q = 0; q < 5; q++) {
            Top.add(keyWords.get(q));

        }

        Collections.sort(Top, new Comparator<KeyWord>() {

            public int compare(KeyWord o1, KeyWord o2) {
                return o1.word.compareTo(o2.word);
            }
        });


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Show top 5");
        for (int q = 0; q < Top.size(); q++) {
            System.out.println(Top.get(q).word + " - " + Top.get(q).counter);
        }
        System.out.println();
        System.out.println();
        System.out.println("Петр,гони бюджет!!!!!");


    }
}





